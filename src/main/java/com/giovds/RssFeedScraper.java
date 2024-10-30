package com.giovds;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RssFeedScraper {

    public List<Article> scrapeRssFeeds(List<String> rssFeedUrls, int year) {
        List<Article> articles = new ArrayList<>();

        for (String rssFeedUrl : rssFeedUrls) {
            try {
                SyndFeed feed = new SyndFeedInput().build(new XmlReader(new URL(rssFeedUrl)));

                for (SyndEntry entry : feed.getEntries()) {
                    LocalDate publishedDate = entry.getPublishedDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    if (publishedDate.getYear() == year) {
                        Article article = new Article(entry.getTitle(), rssFeedUrl, publishedDate);
                        articles.add(article);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return articles;
    }

    public Map<String, List<Article>> groupArticlesByAuthor(List<Article> articles) {
        return articles.stream()
                .collect(Collectors.groupingBy(Article::getFeed));
    }
}

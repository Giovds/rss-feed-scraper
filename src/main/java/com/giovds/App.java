package com.giovds;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the RSS feed URLs (comma separated):");
        String urlsInput = scanner.nextLine();
        List<String> rssFeedUrls = List.of(urlsInput.split(","));

        System.out.println("Enter the year:");
        int year = scanner.nextInt();

        RssFeedScraper scraper = new RssFeedScraper();
        List<Article> articles = scraper.scrapeRssFeeds(rssFeedUrls, year);

        Map<String, List<Article>> articlesByFeed = articles.stream()
                .collect(Collectors.groupingBy(article -> rssFeedUrls.stream()
                        .filter(url -> article.getFeed().contains(url))
                        .findFirst()
                        .orElse("Unknown Feed")));

        articlesByFeed.forEach((feed, feedArticles) -> {
            System.out.println("Feed: " + feed);
            feedArticles.forEach(article -> System.out.println(" - " + article.getTitle()));
        });
    }
}

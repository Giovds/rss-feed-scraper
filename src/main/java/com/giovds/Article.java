package com.giovds;

import java.time.LocalDate;

public record Article(String title, String feed, LocalDate publicationDate) {
    public String getTitle() {
        return title;
    }

    public String getFeed() {
        return feed;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }
}

package com.quiroga.lawapi.model;

import java.time.LocalDate;

public class Article {
        private final Long id;
        private final String title;
        private final String slug;
        private final String summary;
        private final String content;
        private final LocalDate publishedAt;

        public Article(Long id, String title, String slug, String summary, String content, LocalDate publishedAt) {
                this.id = id;
                this.title = title;
                this.slug = slug;
                this.summary = summary;
                this.content = content;
                this.publishedAt = publishedAt;
        }

        public Long getId() {
                return id;
        }

        public String getTitle() {
                return title;
        }

        public String getSlug() {
                return slug;
        }

        public String getSummary() {
                return summary;
        }

        public String getContent() {
                return content;
        }

        public LocalDate getPublishedAt() {
                return publishedAt;
        }
}
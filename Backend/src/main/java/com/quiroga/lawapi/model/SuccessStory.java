package com.quiroga.lawapi.model;

import java.time.LocalDate;

public class SuccessStory {
        private final Long id;
        private final String title;
        private final String clientName;
        private final String caseType;
        private final String story;
        private final LocalDate date;

        public SuccessStory(Long id, String title, String clientName, String caseType, String story, LocalDate date) {
                this.id = id;
                this.title = title;
                this.clientName = clientName;
                this.caseType = caseType;
                this.story = story;
                this.date = date;
        }

        public Long getId() {
                return id;
        }

        public String getTitle() {
                return title;
        }

        public String getClientName() {
                return clientName;
        }

        public String getCaseType() {
                return caseType;
        }

        public String getStory() {
                return story;
        }

        public LocalDate getDate() {
                return date;
        }
}
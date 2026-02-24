package com.quiroga.lawapi.model;

public class TeamMember {
        private final Long id;
        private final String name;
        private final String role;
        private final String bio;
        private final String photoUrl;

        public TeamMember(Long id, String name, String role, String bio, String photoUrl) {
                this.id = id;
                this.name = name;
                this.role = role;
                this.bio = bio;
                this.photoUrl = photoUrl;
        }

        public Long getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public String getRole() {
                return role;
        }

        public String getBio() {
                return bio;
        }

        public String getPhotoUrl() {
                return photoUrl;
        }
}
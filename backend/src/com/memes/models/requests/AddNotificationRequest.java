package com.memes.models.requests;

public class AddNotificationRequest {
    private String email;
    private String url;
    private String fromEmail;

    public AddNotificationRequest() {

    }

    public AddNotificationRequest(AddNotificationRequest.Builder builder) {
        this.email = builder.email;
        this.fromEmail = builder.fromEmail;
        this.url = builder.url;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static AddNotificationRequest.Builder builder() {
        return new AddNotificationRequest.Builder();
    }

    public static final class Builder {
        private String email;
        private String url;
        private String fromEmail;

        private Builder() {

        }

        public AddNotificationRequest.Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public AddNotificationRequest.Builder withUrl(String url) {
            this.url = url;
            return this;
        }
        public AddNotificationRequest.Builder withFromEmail(String fromEmail) {
            this.fromEmail = fromEmail;
            return this;
        }
        public AddNotificationRequest build() { return new AddNotificationRequest(this); }
    }
}

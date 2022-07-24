package com.memes.models.requests;

public class GetEmailUserAndUrlMemeRequest {
    private String email;
    private String url;

    public GetEmailUserAndUrlMemeRequest() {

    }

    public GetEmailUserAndUrlMemeRequest(GetEmailUserAndUrlMemeRequest.Builder builder) {
        this.email = builder.email;
        this.url = builder.url;
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

    public static GetEmailUserAndUrlMemeRequest.Builder builder() {
        return new GetEmailUserAndUrlMemeRequest.Builder();
    }

    public static final class Builder {
        private String email;
        private String url;

        private Builder() {

        }

        public GetEmailUserAndUrlMemeRequest.Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public GetEmailUserAndUrlMemeRequest.Builder withUrl(String url) {
            this.url = url;
            return this;
        }

        public GetEmailUserAndUrlMemeRequest build() { return new GetEmailUserAndUrlMemeRequest(this); }
    }
}

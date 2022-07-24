package com.memes.models.requests;

import java.util.Objects;

public class GetUrlMemeRequest {
    private String url;

    public GetUrlMemeRequest() {

    }

    public GetUrlMemeRequest(GetUrlMemeRequest.Builder builder) {
        this.url = builder.url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetUrlMemeRequest that = (GetUrlMemeRequest) o;
        return Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }

    @Override
    public String toString() {
        return "GetPlaylistRequest{" +
                "url='" + url + '\'' +
                '}';
    }

    public static GetUrlMemeRequest.Builder builder() { return new GetUrlMemeRequest.Builder(); }

    public static final class Builder {
        private String url;

        private Builder() {

        }

        public GetUrlMemeRequest.Builder withUrl(String url) {
            this.url = url;
            return this;
        }

        public GetUrlMemeRequest build() { return new GetUrlMemeRequest(this); }
    }
}

package com.memes.models.results;

public class GetHoroscopeMemeResult {
    private String url;

    public GetHoroscopeMemeResult(GetHoroscopeMemeResult.Builder builder) {
        this.url = builder.url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static GetHoroscopeMemeResult.Builder builder() {return new GetHoroscopeMemeResult.Builder();}

    public static final class Builder {
        private String url;

        public GetHoroscopeMemeResult.Builder withUrl(String url) {
            this.url = url;
            return this;
        }

        public GetHoroscopeMemeResult build() {return new GetHoroscopeMemeResult(this);}
    }
}

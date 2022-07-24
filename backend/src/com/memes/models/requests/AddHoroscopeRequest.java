package com.memes.models.requests;

public class AddHoroscopeRequest {
    private String email;
    private String horoscope;

    public AddHoroscopeRequest() {

    }

    public AddHoroscopeRequest(AddHoroscopeRequest.Builder builder) {
        this.email = builder.email;
        this.horoscope = builder.horoscope;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHoroscope() {
        return horoscope;
    }

    public void setHoroscope(String horoscope) {
        this.horoscope = horoscope;
    }

    public static AddHoroscopeRequest.Builder builder() {
        return new AddHoroscopeRequest.Builder();
    }

    public static final class Builder {
        private String email;
        private String horoscope;

        private Builder() {

        }

        public AddHoroscopeRequest.Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public AddHoroscopeRequest.Builder withHoroscope(String horoscope) {
            this.horoscope = horoscope;
            return this;
        }
        public AddHoroscopeRequest build() { return new AddHoroscopeRequest(this); }
    }
}

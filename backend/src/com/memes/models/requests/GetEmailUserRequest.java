package com.memes.models.requests;

public class GetEmailUserRequest {
    private String email;

    public GetEmailUserRequest() {

    }

    public GetEmailUserRequest(GetEmailUserRequest.Builder builder) {
        this.email = builder.email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static GetEmailUserRequest.Builder builder() { return new GetEmailUserRequest.Builder(); }

    public static final class Builder {
        private String email;

        private Builder() {

        }

        public GetEmailUserRequest.Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public GetEmailUserRequest build() { return new GetEmailUserRequest(this); }
    }
}

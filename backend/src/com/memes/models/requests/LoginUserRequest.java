package com.memes.models.requests;

public class LoginUserRequest {
    private String email;
    private String password;

    public LoginUserRequest(LoginUserRequest.Builder builder) {
        this.email = builder.email;
        this.password = builder.password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static LoginUserRequest.Builder builder() {return new LoginUserRequest.Builder();}

    public static final class Builder {
        private String email;
        private String password;

        public LoginUserRequest.Builder withUser(String email) {
            this.email = email;
            return this;
        }
        public LoginUserRequest.Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public LoginUserRequest build() {return new LoginUserRequest(this);}
    }
}

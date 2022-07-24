package com.memes.models.results;

public class LoginUserResult {
    private String email;
    private Boolean success;

    public LoginUserResult(LoginUserResult.Builder builder) {
        this.email = builder.email;
        this.success = builder.success;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public static LoginUserResult.Builder builder() {return new LoginUserResult.Builder();}

    public static final class Builder {
        private String email;
        private Boolean success;

        public LoginUserResult.Builder withUser(String email) {
            this.email = email;
            return this;
        }
        public LoginUserResult.Builder withSuccess(Boolean success) {
            this.success = success;
            return this;
        }

        public LoginUserResult build() {return new LoginUserResult(this);}
    }
}

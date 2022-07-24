package com.memes.models.results;

import com.memes.models.UserModel;

public class CreateUserResult {
    private String email;
    private Boolean success;

    public CreateUserResult(CreateUserResult.Builder builder) {
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

    public static CreateUserResult.Builder builder() {return new CreateUserResult.Builder();}

    public static final class Builder {
        private String email;
        private Boolean success;

        public CreateUserResult.Builder withUser(String email) {
            this.email = email;
            return this;
        }
        public CreateUserResult.Builder withSuccess(Boolean success) {
            this.success = success;
            return this;
        }

        public CreateUserResult build() {return new CreateUserResult(this);}
    }
}

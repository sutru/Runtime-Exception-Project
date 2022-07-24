package com.memes.models.requests;

import com.memes.models.results.CreateUserResult;
import com.memes.models.results.GetEmailUserResult;

public class CreateUserRequest {
    private String email;
    private String password;

    public CreateUserRequest(CreateUserRequest.Builder builder) {
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

    public static CreateUserRequest.Builder builder() {return new CreateUserRequest.Builder();}

    public static final class Builder {
        private String email;
        private String password;

        public CreateUserRequest.Builder withUser(String email) {
            this.email = email;
            return this;
        }
        public CreateUserRequest.Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public CreateUserRequest build() {return new CreateUserRequest(this);}
    }
}

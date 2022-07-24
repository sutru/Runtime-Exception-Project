package com.memes.models.results;

import com.memes.models.UserModel;

public class GetEmailUserResult {
    private UserModel userModel;

    public GetEmailUserResult(GetEmailUserResult.Builder builder) {
        this.userModel = builder.userModel;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public static GetEmailUserResult.Builder builder() {return new GetEmailUserResult.Builder();}

    public static final class Builder {
        private UserModel userModel;

        public GetEmailUserResult.Builder withUser(UserModel userModel) {
            this.userModel = userModel;
            return this;
        }

        public GetEmailUserResult build() {return new GetEmailUserResult(this);}
    }
}

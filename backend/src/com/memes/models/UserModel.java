package com.memes.models;

import com.memes.dynamodb.models.User;

import java.util.List;

public class UserModel {
    private String userName;
    private String email;
    private List<String> memeLikedList;

    public UserModel(){

    }
    public UserModel(UserModel.Builder builder) {
        this.userName = builder.userName;
        this.email = builder.email;
        this.memeLikedList = builder.memeLikedList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getMemeLikedList() { return memeLikedList; }

    public void setMemeLikedList(List<String> memeLikedList) { this.memeLikedList = memeLikedList; }

    public static UserModel.Builder builder() { return new UserModel.Builder(); }

    public static final class Builder {
        private String userName;
        private String email;
        private List<String> memeLikedList;

        public UserModel.Builder withUserName(String userNameToUse) {
            this.userName = userNameToUse;
            return this;
        }

        public UserModel.Builder withEmail(String emailToUse) {
            this.email = emailToUse;
            return this;
        }

        public UserModel.Builder withMemeLikedList(List<String> memeLikedListToUse) {
            this.memeLikedList = memeLikedListToUse;
            return this;
        }

        public UserModel build() {return new UserModel(this);}
    }
}

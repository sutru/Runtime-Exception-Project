package com.memes.models.results;

import java.util.List;

public class UserMemeLikedListResult {
    private List<String> memeLikedList;

    public UserMemeLikedListResult(UserMemeLikedListResult.Builder builder) {
        this.memeLikedList = builder.memeLikedList;
    }

    public List<String> getMemeLikedList() {
        return memeLikedList;
    }

    public void setMemeLikedList(List<String> memeLikedList) {
        this.memeLikedList = memeLikedList;
    }

    public static UserMemeLikedListResult.Builder builder() {return new UserMemeLikedListResult.Builder();}

    public static final class Builder {
        private List<String> memeLikedList;

        public UserMemeLikedListResult.Builder withUserMemeLikedList(List<String> memeLikedList) {
            this.memeLikedList = memeLikedList;
            return this;
        }

        public UserMemeLikedListResult build() {return new UserMemeLikedListResult(this);}
    }
}

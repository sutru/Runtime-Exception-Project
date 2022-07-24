package com.memes.models.results;

import java.util.List;

public class AddNotificationResult {
    private List<String> notifications;

    public AddNotificationResult(AddNotificationResult.Builder builder) {
        this.notifications = builder.notifications;
    }

    public List<String> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<String> notifications) {
        this.notifications = notifications;
    }

    public static AddNotificationResult.Builder builder() {return new AddNotificationResult.Builder();}

    public static final class Builder {
        private List<String> notifications;

        public AddNotificationResult.Builder withNotifications(List<String> notifications) {
            this.notifications = notifications;
            return this;
        }

        public AddNotificationResult build() {return new AddNotificationResult(this);}
    }
}

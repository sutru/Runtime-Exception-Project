package com.memes.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.memes.dynamodb.UserDao;
import com.memes.dynamodb.models.User;
import com.memes.exceptions.InvalidInputException;
import com.memes.models.requests.AddNotificationRequest;
import com.memes.models.results.AddNotificationResult;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class AddMemeToNotificationsActivity implements RequestHandler<AddNotificationRequest, AddNotificationResult> {
    private UserDao userDao;

    @Inject
    public AddMemeToNotificationsActivity(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public AddNotificationResult handleRequest(AddNotificationRequest input, Context context) {
        // Retrieve user inputs
        String email = input.getEmail();
        String url = input.getUrl();
        String fromEmail = input.getFromEmail();

        User user = userDao.getUser(email);
        List<String> notifications = user.getNotifications();
        if (notifications == null) notifications = new ArrayList<>();
        if (url.isEmpty()) throw new InvalidInputException("Url is empty");

        notifications.add(fromEmail);
        notifications.add(url);

        user.setNotifications(notifications);
        user = userDao.saveUser(user);

        return AddNotificationResult.builder()
                .withNotifications(user.getNotifications())
                .build();
    }
}

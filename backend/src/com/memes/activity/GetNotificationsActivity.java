package com.memes.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.memes.dynamodb.UserDao;
import com.memes.dynamodb.models.User;
import com.memes.exceptions.InvalidInputException;
import com.memes.models.requests.AddNotificationRequest;
import com.memes.models.requests.GetEmailUserRequest;
import com.memes.models.results.AddNotificationResult;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class GetNotificationsActivity implements RequestHandler<GetEmailUserRequest, AddNotificationResult> {
    private UserDao userDao;

    @Inject
    public GetNotificationsActivity(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public AddNotificationResult handleRequest(GetEmailUserRequest input, Context context) {
        // Retrieve user inputs
        String email = input.getEmail();

        User user = userDao.getUser(email);
        List<String> notifications = user.getNotifications();
        if (notifications == null) notifications = new ArrayList<>();
        
        return AddNotificationResult.builder()
                .withNotifications(user.getNotifications())
                .build();
    }
}

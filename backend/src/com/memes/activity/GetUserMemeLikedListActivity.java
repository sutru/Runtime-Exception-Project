package com.memes.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.memes.dynamodb.UserDao;
import com.memes.dynamodb.models.User;
import com.memes.exceptions.UserNotFoundException;
import com.memes.models.requests.GetEmailUserRequest;
import com.memes.models.results.UserMemeLikedListResult;

import javax.inject.Inject;

public class GetUserMemeLikedListActivity implements RequestHandler<GetEmailUserRequest, UserMemeLikedListResult> {

    private UserDao userDao;

    @Inject
    public GetUserMemeLikedListActivity(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserMemeLikedListResult handleRequest(final GetEmailUserRequest input, Context context) {
        String email = input.getEmail();
        User user = userDao.getUser(email);

        if (user == null) throw new UserNotFoundException("User not found in database");

        return UserMemeLikedListResult.builder()
                .withUserMemeLikedList(user.getMemeLikedList())
                .build();
    }

}

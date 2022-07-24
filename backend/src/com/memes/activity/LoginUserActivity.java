package com.memes.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.memes.dynamodb.UserDao;
import com.memes.dynamodb.models.User;
import com.memes.models.requests.LoginUserRequest;
import com.memes.models.results.LoginUserResult;

import javax.inject.Inject;

public class LoginUserActivity implements RequestHandler<LoginUserRequest, LoginUserResult>  {
    private UserDao userDao;

    @Inject
    public LoginUserActivity(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public LoginUserResult handleRequest(LoginUserRequest input, Context context) {
        User user = userDao.getUser(input.getEmail());
        if (user != null) {
            int hash = input.getPassword().hashCode();
            if (hash == user.getPassword()) {
                return LoginUserResult.builder()
                        .withSuccess(true)
                        .withUser(input.getEmail())
                        .build();
            }
        }
        return LoginUserResult.builder()
                .withSuccess(false)
                .withUser(input.getEmail())
                .build();
    }
}

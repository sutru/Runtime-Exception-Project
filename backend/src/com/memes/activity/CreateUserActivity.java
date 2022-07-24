package com.memes.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.memes.dynamodb.UserDao;
import com.memes.dynamodb.models.User;
import com.memes.models.requests.CreateUserRequest;
import com.memes.models.results.CreateUserResult;

import javax.inject.Inject;

public class CreateUserActivity  implements RequestHandler<CreateUserRequest, CreateUserResult> {
    private UserDao userDao;

    @Inject
    public CreateUserActivity(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public CreateUserResult handleRequest(CreateUserRequest input, Context context) {
        User user = userDao.getUser(input.getEmail());
        if (user == null) {
            user.setEmail(input.getEmail());
            user.setPassword(input.getPassword().hashCode());
            userDao.saveUser(user);
            return CreateUserResult.builder()
                    .withSuccess(true)
                    .withUser(input.getEmail())
                    .build();
        }
        return CreateUserResult.builder()
                .withSuccess(false)
                .withUser(input.getEmail())
                .build();
    }
}

package com.memes.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.memes.converter.ModelConverter;
import com.memes.dynamodb.MemeDao;
import com.memes.dynamodb.UserDao;
import com.memes.dynamodb.models.User;
import com.memes.models.MemeModel;
import com.memes.models.UserModel;
import com.memes.models.requests.GetEmailUserRequest;
import com.memes.models.requests.GetIndexMemeRequest;
import com.memes.models.results.GetEmailUserResult;

import javax.inject.Inject;

public class GetEmailUserActivity implements RequestHandler<GetEmailUserRequest, GetEmailUserResult> {
    private UserDao userDao;

    @Inject
    public GetEmailUserActivity(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public GetEmailUserResult handleRequest(final GetEmailUserRequest input, Context context) {
        User user = userDao.getUser(input.getEmail());
        UserModel userModel = new ModelConverter().toUserModel(user);

        return GetEmailUserResult.builder()
                .withUser(userModel)
                .build();
    }
}
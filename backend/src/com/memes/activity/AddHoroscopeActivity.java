package com.memes.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.memes.converter.ModelConverter;
import com.memes.dynamodb.UserDao;
import com.memes.dynamodb.models.User;
import com.memes.exceptions.InvalidInputException;
import com.memes.models.UserModel;
import com.memes.models.requests.AddHoroscopeRequest;
import com.memes.models.requests.AddNotificationRequest;
import com.memes.models.results.AddNotificationResult;
import com.memes.models.results.GetEmailUserResult;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class AddHoroscopeActivity implements RequestHandler<AddHoroscopeRequest, GetEmailUserResult> {
    private UserDao userDao;

    @Inject
    public AddHoroscopeActivity(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public GetEmailUserResult handleRequest(AddHoroscopeRequest input, Context context) {
        // Retrieve user inputs
        String email = input.getEmail();
        String horoscope = input.getHoroscope();
        // arbitrary change
        User user = userDao.getUser(email);



        user.setHoroscope(horoscope);
        user = userDao.saveUser(user);
        UserModel userModel = new ModelConverter().toUserModel(user);
        return GetEmailUserResult.builder()
                .withUser(userModel)
                .build();
    }
}

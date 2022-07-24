package com.memes.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.memes.converter.ModelConverter;
import com.memes.dynamodb.MemeDao;
import com.memes.dynamodb.UserDao;
import com.memes.dynamodb.models.Meme;
import com.memes.dynamodb.models.User;
import com.memes.models.MemeModel;
import com.memes.models.UserModel;
import com.memes.models.requests.GetUrlMemeRequest;
import com.memes.models.results.GetUrlMemeResult;

import javax.inject.Inject;

    public class UserPoolMapperActivity implements RequestHandler<Object, String> {
    private UserDao userDao;
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Inject
    public UserPoolMapperActivity(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String handleRequest(final Object event, Context context) {
        User user = new User();
        JsonObject json = gson.fromJson(gson.toJson(event), JsonObject.class);
        user.setUserName(json.get("userName").getAsString());
        user.setEmail(json.get("request").getAsJsonObject()
                .get("userAttributes").getAsJsonObject()
                .get("email").getAsString());
        userDao.saveUser(user);
        UserModel userModel = new ModelConverter().toUserModel(user);
        return "SUCCESS";
    }
}
package com.memes.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.memes.dynamodb.UserDao;
import com.memes.dynamodb.models.User;
import com.memes.exceptions.DuplicateMemeFoundException;
import com.memes.exceptions.InvalidInputException;
import com.memes.models.requests.GetEmailUserAndUrlMemeRequest;
import com.memes.models.results.UserMemeLikedListResult;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class AddMemeToUserMemeLikedListActivity implements RequestHandler<GetEmailUserAndUrlMemeRequest, UserMemeLikedListResult> {
    private UserDao userDao;

    @Inject
    public AddMemeToUserMemeLikedListActivity(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserMemeLikedListResult handleRequest(GetEmailUserAndUrlMemeRequest input, Context context) {
        // Retrieve user inputs
        String email = input.getEmail();
        String url = input.getUrl();

        User user = userDao.getUser(email);
        List<String> memeLikedList = user.getMemeLikedList();
        if (memeLikedList == null) memeLikedList = new ArrayList<>();
        if (memeLikedList.contains(url)) throw new DuplicateMemeFoundException(url + " is already in this user's liked list");
        if (url.isEmpty()) throw new InvalidInputException("Url is empty");

        memeLikedList.add(url);

        user.setMemeLikedList(memeLikedList);
        user = userDao.saveUser(user);

        return UserMemeLikedListResult.builder()
                .withUserMemeLikedList(user.getMemeLikedList())
                .build();
    }
}

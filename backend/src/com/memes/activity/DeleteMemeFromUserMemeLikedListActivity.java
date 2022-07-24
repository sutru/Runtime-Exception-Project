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
import java.util.List;

public class DeleteMemeFromUserMemeLikedListActivity implements RequestHandler<GetEmailUserAndUrlMemeRequest, UserMemeLikedListResult> {
    private UserDao userDao;

    @Inject
    public DeleteMemeFromUserMemeLikedListActivity(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserMemeLikedListResult handleRequest(GetEmailUserAndUrlMemeRequest input, Context context) {
        // Retrieve user inputs
        String email = input.getEmail();
        String url = input.getUrl();

        User user = userDao.getUser(email);
        List<String> memeLikedList = user.getMemeLikedList();

        if (memeLikedList.isEmpty()) throw new RuntimeException("List is empty");
        if (url.isEmpty()) throw new InvalidInputException("Url is empty");
        if (!memeLikedList.contains(url)) throw new RuntimeException("List does not contain this meme");
        memeLikedList.remove(url);

        user.setMemeLikedList(memeLikedList);
        user = userDao.saveUser(user);

        return UserMemeLikedListResult.builder()
                .withUserMemeLikedList(user.getMemeLikedList())
                .build();
    }
}

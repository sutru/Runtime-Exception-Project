package com.memes.converter;

import com.memes.dynamodb.models.Meme;
import com.memes.dynamodb.models.User;
import com.memes.models.MemeModel;
import com.memes.models.UserModel;


public class ModelConverter {
    public MemeModel toMemeModel(Meme meme) {
        return MemeModel.builder()
                .withNumInDb(meme.getNumInDb())
                .withName(meme.getName())
                .withUrl(meme.getUrl())
                .build();
    }
    public UserModel toUserModel(User user) {
        return UserModel.builder()
                .withUserName(user.getUserName())
                .withEmail(user.getEmail())
                .withMemeLikedList(user.getMemeLikedList())
                .build();
    }
}

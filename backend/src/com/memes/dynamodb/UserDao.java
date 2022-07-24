package com.memes.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.memes.dynamodb.models.User;

import javax.inject.Inject;

public class UserDao {
    DynamoDBMapper dynamoDBMapper;
    @Inject
    public UserDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public User saveUser(User user) {
        dynamoDBMapper.save(user);
        return user;
    }

    public User getUser(String email) {
        User user = dynamoDBMapper.load(User.class, email);
        return user;
    }

}

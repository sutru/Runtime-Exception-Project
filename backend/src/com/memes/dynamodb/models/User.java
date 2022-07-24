package com.memes.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.List;

@DynamoDBTable(tableName = "Users")
public class User {
    private String userName;
    private String email;
    private Integer password;
    private String horoscope;
    private List<String> memeLikedList;
    private List<String> notifications;
    public User () {

    }

    @DynamoDBHashKey(attributeName = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @DynamoDBAttribute(attributeName = "password")
    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    @DynamoDBAttribute(attributeName = "userName")
    public String getUserName() {
        return userName;
    }

    @DynamoDBAttribute(attributeName = "memeLikedList")
    public List<String> getMemeLikedList() {
        return memeLikedList;
    }

    public void setMemeLikedList(List<String> memeLikedList) {
        this.memeLikedList = memeLikedList;
    }

    @DynamoDBAttribute(attributeName = "notifications")
    public List<String> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<String> notifications) {
        this.notifications = notifications;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @DynamoDBAttribute(attributeName = "horoscope")
    public String getHoroscope() {
        return horoscope;
    }

    public void setHoroscope(String horoscope) {
        this.horoscope = horoscope;
    }
}
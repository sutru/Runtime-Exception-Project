package com.memes.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "Memes")
public class Meme {
    private String url;
    private String name;
    private Integer numInDb;
    @DynamoDBHashKey(attributeName = "Url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @DynamoDBIndexHashKey(globalSecondaryIndexName = "index-index", attributeName = "numInDB")
    public Integer getNumInDb() {
        return numInDb;
    }

    public void setNumInDb(Integer numInDb) {
        this.numInDb = numInDb;
    }

    @DynamoDBAttribute(attributeName = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
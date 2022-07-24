package com.memes.dependency;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;
@Module
public class DaoModule {

    @Singleton
    @Provides
    public DynamoDBMapper provideDynamoDBWrapper() {
        AmazonDynamoDB dynamoDBClient = AmazonDynamoDBClientBuilder.standard().withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
                .withRegion(Regions.US_WEST_2).build();
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(dynamoDBClient);
        return dynamoDBMapper;
    }
}

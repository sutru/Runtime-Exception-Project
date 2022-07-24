package com.memes.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.memes.dynamodb.models.Meme;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class MemeDao {
    DynamoDBMapper dynamoDBMapper;
    @Inject
    public MemeDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }


    public Meme getMemeByNumInDb(Integer numInDb) {
        Map<String, AttributeValue> valueMap = new HashMap<>();

        valueMap.put(":numInDB", new AttributeValue().withN(numInDb.toString()));
        DynamoDBQueryExpression<Meme> queryExpression = new DynamoDBQueryExpression<Meme>()
                .withIndexName("numInDB-index")
                .withConsistentRead(false)
                .withKeyConditionExpression("numInDB = :numInDB")
                .withExpressionAttributeValues(valueMap);

        PaginatedQueryList<Meme> memeList = dynamoDBMapper.query(Meme.class, queryExpression);
        return memeList.get(0);
    }

    public Meme getMemeByUrl(String url) {
        Meme meme = dynamoDBMapper.load(Meme.class, url);
        return meme;
    }
}

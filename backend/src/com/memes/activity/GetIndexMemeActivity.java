package com.memes.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.memes.converter.ModelConverter;
import com.memes.dynamodb.MemeDao;
import com.memes.dynamodb.models.Meme;
import com.memes.models.MemeModel;
import com.memes.models.requests.GetIndexMemeRequest;
import com.memes.models.results.GetIndexMemeResult;

import javax.inject.Inject;

public class GetIndexMemeActivity implements RequestHandler<GetIndexMemeRequest, GetIndexMemeResult> {
    private MemeDao memeDao;
    @Inject
    public GetIndexMemeActivity(MemeDao memeDao) {
        this.memeDao = memeDao;
    }

    @Override
    public GetIndexMemeResult handleRequest(final GetIndexMemeRequest input, Context context) {
        Integer numInDb = input.getNumInDb();
        Meme meme = memeDao.getMemeByNumInDb(numInDb);
        MemeModel memeModel = new ModelConverter().toMemeModel(meme);
        return GetIndexMemeResult.builder()
                .withMeme(memeModel)
                .build();
    }
}

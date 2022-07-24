package com.memes.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.memes.converter.ModelConverter;
import com.memes.dynamodb.MemeDao;
import com.memes.dynamodb.models.Meme;
import com.memes.models.MemeModel;
import com.memes.models.requests.GetIndexMemeRequest;
import com.memes.models.requests.GetUrlMemeRequest;
import com.memes.models.results.GetIndexMemeResult;
import com.memes.models.results.GetUrlMemeResult;

import javax.inject.Inject;

public class GetUrlMemeActivity implements RequestHandler<GetUrlMemeRequest, GetUrlMemeResult> {
    private MemeDao memeDao;
    @Inject
    public GetUrlMemeActivity(MemeDao memeDao) {
        this.memeDao = memeDao;
    }

    @Override
    public GetUrlMemeResult handleRequest(final GetUrlMemeRequest input, Context context) {
        String url = input.getUrl();
        Meme meme = memeDao.getMemeByUrl(url);
        MemeModel memeModel = new ModelConverter().toMemeModel(meme);
        return GetUrlMemeResult.builder()
                .withMeme(memeModel)
                .build();
    }
}
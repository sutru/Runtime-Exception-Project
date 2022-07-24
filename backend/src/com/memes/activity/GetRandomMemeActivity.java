package com.memes.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.memes.converter.ModelConverter;
import com.memes.dynamodb.MemeDao;
import com.memes.dynamodb.models.Meme;
import com.memes.models.MemeModel;
import com.memes.models.requests.GetRandomMemeRequest;
import com.memes.models.results.GetIndexMemeResult;
import com.memes.models.results.GetRandomMemeResult;

import javax.inject.Inject;
import java.util.Random;

public class GetRandomMemeActivity implements RequestHandler<GetRandomMemeRequest, GetRandomMemeResult> {
    public static final String SIZE_URL = "AmountInDb";
    Random r;
    private MemeDao memeDao;
    @Inject
    public GetRandomMemeActivity(MemeDao memeDao) {
        this.memeDao = memeDao;
        r = new Random();

    }

    @Override
    public GetRandomMemeResult handleRequest(final GetRandomMemeRequest input, Context context) {
        Meme amount = memeDao.getMemeByUrl(SIZE_URL);
        Meme meme = memeDao.getMemeByNumInDb(r.nextInt(amount.getNumInDb() * -1));
        MemeModel memeModel = new ModelConverter().toMemeModel(meme);
        return GetRandomMemeResult.builder()
                .withMeme(memeModel)
                .build();
    }
}

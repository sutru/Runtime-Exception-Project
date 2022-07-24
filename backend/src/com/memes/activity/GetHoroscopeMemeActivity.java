package com.memes.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.memes.converter.ModelConverter;
import com.memes.dynamodb.MemeDao;
import com.memes.dynamodb.UserDao;
import com.memes.dynamodb.models.Meme;
import com.memes.dynamodb.models.User;
import com.memes.models.UserModel;
import com.memes.models.requests.GetEmailUserRequest;
import com.memes.models.results.GetHoroscopeMemeResult;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class GetHoroscopeMemeActivity implements RequestHandler<GetEmailUserRequest, GetHoroscopeMemeResult> {
    private UserDao userDao;
    private MemeDao memeDao;

    @Inject
    public GetHoroscopeMemeActivity(UserDao userDao, MemeDao memeDao) {
        this.userDao = userDao;
        this.memeDao = memeDao;
    }

    @Override
    public GetHoroscopeMemeResult handleRequest(GetEmailUserRequest input, Context context) {
        // Retrieve user inputs
        String email = input.getEmail();
        // arbitrary change
        User user = userDao.getUser(email);
        String horoscope = user.getHoroscope();
        if(horoscope.isEmpty()){
            return GetHoroscopeMemeResult.builder()
                    .withUrl("no horo")
                    .build();
        }

        Meme meme = memeDao.getMemeByUrl("AmountInDb");
        Integer amountOfMemesInDB = meme.getNumInDb() * -1;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        long seed = Long.parseLong(dtf.format(now).replaceAll("/", ""));
        Long longValueOfHoroscope = horoScopeToLong(horoscope);

        Random random = new Random((seed/longValueOfHoroscope));
        int indexOfMeme = random.nextInt(amountOfMemesInDB);
        LambdaLogger logger = context.getLogger();
        meme = memeDao.getMemeByNumInDb(indexOfMeme);
        logger.log(meme.getUrl());
        return GetHoroscopeMemeResult.builder()
                .withUrl(meme.getUrl())
                .build();
    }

    private Long horoScopeToLong(String horoscope) {
        Long value;
        switch (horoscope) {
            case "Aries" : value = (long) 1.0;
                break;
            case "Taurus" : value = (long) 2.0;
                break;
            case "Gemini" : value = (long) 3.0;
                break;
            case "Cancer" : value = (long) 4.0;
                break;
            case "Leo" : value = (long) 5.0;
                break;
            case "Virgo" : value = (long) 6.0;
                break;
            case "Libra" : value = (long) 7.0;
                break;
            case "Scorpio" : value = (long) 8.0;
                break;
            case "Sagittarius" : value = (long) 9.0;
                break;
            case "Capricorn" : value = (long) 10.0;
                break;
            case "Aquarius" : value = (long) 11.0;
                break;
            case "Pisces" : value = (long) 12.0;
                break;
            default: value = (long) -1.0;
                break;
        }
        return value;
    }
}

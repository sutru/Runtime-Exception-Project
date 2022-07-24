package com.memes.dependency;
import com.memes.activity.*;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {
    GetIndexMemeActivity provideGetIndexMemeActivity();
    GetUrlMemeActivity provideGetUrlMemeActivity();
    GetRandomMemeActivity provideGetRandomMemeActivity();
    UserPoolMapperActivity provideUserPoolMapperActivity();
    GetEmailUserActivity provideGetEmailUserActivity();
    GetUserMemeLikedListActivity provideGetUserMemeLikedListActivity();
    AddMemeToUserMemeLikedListActivity provideAddMemeToUserMemeLikedListActivity();
    DeleteMemeFromUserMemeLikedListActivity provideDeleteMemeFromUserMemeLikedListActivity();
    AddMemeToNotificationsActivity provideAddMemeToNotificationsActivity();
    GetNotificationsActivity provideGetNotificationsActivity();
    AddHoroscopeActivity provideAddHoroscopeActivity();
    GetHoroscopeMemeActivity provideGetHoroscopeMemeActivity();
    CreateUserActivity provideCreateUserActivity();
    LoginUserActivity provideLoginUserActivity();
}

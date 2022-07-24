package com.memes.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.memes.dependency.DaggerServiceComponent;
import com.memes.dependency.ServiceComponent;
import com.memes.models.requests.AddHoroscopeRequest;
import com.memes.models.requests.GetEmailUserAndUrlMemeRequest;
import com.memes.models.results.GetEmailUserResult;
import com.memes.models.results.UserMemeLikedListResult;

public class AddHoroscopeProvider implements RequestHandler<AddHoroscopeRequest, GetEmailUserResult> {
    @Override
    public GetEmailUserResult handleRequest(AddHoroscopeRequest input, Context context) {
        ServiceComponent dagger = getDaggerServiceComponent();
        return dagger.provideAddHoroscopeActivity().handleRequest(input, context);
    }
    private ServiceComponent getDaggerServiceComponent() {
        return DaggerServiceComponent.create();
    }
}

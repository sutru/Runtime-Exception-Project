package com.memes.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.memes.dependency.DaggerServiceComponent;
import com.memes.dependency.ServiceComponent;
import com.memes.models.requests.GetEmailUserRequest;
import com.memes.models.results.GetHoroscopeMemeResult;

public class GetHoroscopeMemeProvider implements RequestHandler<GetEmailUserRequest, GetHoroscopeMemeResult> {
    @Override
    public GetHoroscopeMemeResult handleRequest(GetEmailUserRequest input, Context context) {
        ServiceComponent dagger = getDaggerServiceComponent();
        return dagger.provideGetHoroscopeMemeActivity().handleRequest(input, context);
    }

    private ServiceComponent getDaggerServiceComponent() {
        return DaggerServiceComponent.create();
    }
}
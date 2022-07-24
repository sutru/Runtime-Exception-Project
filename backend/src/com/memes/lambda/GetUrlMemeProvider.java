package com.memes.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.memes.dependency.DaggerServiceComponent;
import com.memes.dependency.ServiceComponent;
import com.memes.models.requests.GetUrlMemeRequest;
import com.memes.models.results.GetUrlMemeResult;

public class GetUrlMemeProvider implements RequestHandler<GetUrlMemeRequest, GetUrlMemeResult> {

    @Override
    public GetUrlMemeResult handleRequest(final GetUrlMemeRequest input, Context context) {
        ServiceComponent dagger = getDaggerServiceComponent();
        return dagger.provideGetUrlMemeActivity().handleRequest(input, context);
    }
    private ServiceComponent getDaggerServiceComponent() {
        return DaggerServiceComponent.create();
    }
}

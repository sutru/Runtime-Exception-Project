package com.memes.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.memes.dependency.DaggerServiceComponent;
import com.memes.dependency.ServiceComponent;
import com.memes.models.requests.GetRandomMemeRequest;
import com.memes.models.results.GetRandomMemeResult;

public class GetRandomMemeProvider implements RequestHandler<GetRandomMemeRequest, GetRandomMemeResult> {
    @Override
    public GetRandomMemeResult handleRequest(final GetRandomMemeRequest input, Context context) {
        ServiceComponent dagger = getDaggerServiceComponent();
        return dagger.provideGetRandomMemeActivity().handleRequest(input, context);

    }

    private ServiceComponent getDaggerServiceComponent() {
        return DaggerServiceComponent.create();
    }
}
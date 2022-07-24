package com.memes.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.memes.dependency.DaggerServiceComponent;
import com.memes.dependency.ServiceComponent;
import com.memes.models.requests.GetIndexMemeRequest;
import com.memes.models.results.GetIndexMemeResult;

public class GetIndexMemeProvider implements RequestHandler<GetIndexMemeRequest, GetIndexMemeResult> {
    @Override
    public GetIndexMemeResult handleRequest(final GetIndexMemeRequest input, Context context) {
        ServiceComponent dagger = getDaggerServiceComponent();
        return dagger.provideGetIndexMemeActivity().handleRequest(input, context);
    }
    private ServiceComponent getDaggerServiceComponent() {
        return DaggerServiceComponent.create();
    }
}

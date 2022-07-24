package com.memes.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.memes.dependency.DaggerServiceComponent;
import com.memes.dependency.ServiceComponent;
import com.memes.models.requests.GetEmailUserRequest;
import com.memes.models.results.GetEmailUserResult;

public class GetEmailUserProvider implements RequestHandler<GetEmailUserRequest, GetEmailUserResult> {
    @Override
    public GetEmailUserResult handleRequest(GetEmailUserRequest input, Context context) {
        ServiceComponent dagger = getDaggerServiceComponent();
        return dagger.provideGetEmailUserActivity().handleRequest(input, context);
    }

    private ServiceComponent getDaggerServiceComponent() {
        return DaggerServiceComponent.create();
    }
}

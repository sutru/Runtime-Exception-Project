package com.memes.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.memes.dependency.DaggerServiceComponent;
import com.memes.dependency.ServiceComponent;
import com.memes.models.requests.AddNotificationRequest;
import com.memes.models.requests.CreateUserRequest;
import com.memes.models.results.AddNotificationResult;
import com.memes.models.results.CreateUserResult;

public class CreateUserProvider implements RequestHandler<CreateUserRequest, CreateUserResult> {
    @Override
    public CreateUserResult handleRequest(CreateUserRequest input, Context context) {
        ServiceComponent dagger = getDaggerServiceComponent();
        return dagger.provideCreateUserActivity().handleRequest(input, context);
    }
    private ServiceComponent getDaggerServiceComponent() {
        return DaggerServiceComponent.create();
    }
}

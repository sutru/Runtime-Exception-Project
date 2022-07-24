package com.memes.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.memes.dependency.DaggerServiceComponent;
import com.memes.dependency.ServiceComponent;
import com.memes.models.requests.CreateUserRequest;
import com.memes.models.requests.LoginUserRequest;
import com.memes.models.results.CreateUserResult;
import com.memes.models.results.LoginUserResult;

public class LoginUserProvider implements RequestHandler<LoginUserRequest, LoginUserResult> {
    @Override
    public LoginUserResult handleRequest(LoginUserRequest input, Context context) {
        ServiceComponent dagger = getDaggerServiceComponent();
        return dagger.provideLoginUserActivity().handleRequest(input, context);
    }
    private ServiceComponent getDaggerServiceComponent() {
        return DaggerServiceComponent.create();
    }
}

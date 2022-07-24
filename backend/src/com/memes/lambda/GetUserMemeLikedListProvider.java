package com.memes.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.memes.dependency.DaggerServiceComponent;
import com.memes.dependency.ServiceComponent;
import com.memes.models.requests.GetEmailUserRequest;
import com.memes.models.results.UserMemeLikedListResult;

public class GetUserMemeLikedListProvider implements RequestHandler<GetEmailUserRequest, UserMemeLikedListResult> {
    @Override
    public UserMemeLikedListResult handleRequest(GetEmailUserRequest input, Context context) {
        ServiceComponent dagger = getDaggerServiceComponent();
        return dagger.provideGetUserMemeLikedListActivity().handleRequest(input, context);

    }
    private ServiceComponent getDaggerServiceComponent() {
        return DaggerServiceComponent.create();
    }
}

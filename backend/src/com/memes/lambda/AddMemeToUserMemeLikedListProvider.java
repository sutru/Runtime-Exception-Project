package com.memes.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.memes.dependency.ServiceComponent;
import com.memes.models.requests.GetEmailUserAndUrlMemeRequest;
import com.memes.models.results.UserMemeLikedListResult;
import com.memes.dependency.DaggerServiceComponent;

public class AddMemeToUserMemeLikedListProvider implements RequestHandler<GetEmailUserAndUrlMemeRequest, UserMemeLikedListResult> {
    @Override
    public UserMemeLikedListResult handleRequest(GetEmailUserAndUrlMemeRequest input, Context context) {
        ServiceComponent dagger = getDaggerServiceComponent();
        return dagger.provideAddMemeToUserMemeLikedListActivity().handleRequest(input, context);
    }
    private ServiceComponent getDaggerServiceComponent() {
        return DaggerServiceComponent.create();
    }

}

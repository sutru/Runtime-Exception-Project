package com.memes.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.memes.dependency.DaggerServiceComponent;
import com.memes.dependency.ServiceComponent;
import com.memes.models.requests.AddNotificationRequest;
import com.memes.models.requests.GetEmailUserAndUrlMemeRequest;
import com.memes.models.results.AddNotificationResult;
import com.memes.models.results.UserMemeLikedListResult;

public class AddNotificationProvider implements RequestHandler<AddNotificationRequest, AddNotificationResult> {
    @Override
    public AddNotificationResult handleRequest(AddNotificationRequest input, Context context) {
        ServiceComponent dagger = getDaggerServiceComponent();
        return dagger.provideAddMemeToNotificationsActivity().handleRequest(input, context);
    }
    private ServiceComponent getDaggerServiceComponent() {
        return DaggerServiceComponent.create();
    }
}

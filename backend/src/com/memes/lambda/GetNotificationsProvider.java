package com.memes.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.memes.dependency.DaggerServiceComponent;
import com.memes.dependency.ServiceComponent;
import com.memes.models.requests.AddNotificationRequest;
import com.memes.models.requests.GetEmailUserRequest;
import com.memes.models.results.AddNotificationResult;

public class GetNotificationsProvider  implements RequestHandler<GetEmailUserRequest, AddNotificationResult> {
    @Override
    public AddNotificationResult handleRequest(GetEmailUserRequest input, Context context) {
        ServiceComponent dagger = getDaggerServiceComponent();
        return dagger.provideGetNotificationsActivity().handleRequest(input, context);
    }
    private ServiceComponent getDaggerServiceComponent() {
        return DaggerServiceComponent.create();
    }
}
package com.memes.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.memes.dependency.DaggerServiceComponent;
import com.memes.dependency.ServiceComponent;


public class UserPoolMapperProvider implements RequestHandler<Object, Object> {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Override
    public Object handleRequest(Object event, Context context) {
        LambdaLogger logger = context.getLogger();
        // log execution details
        logger.log("ENVIRONMENT VARIABLES: " + gson.toJson(System.getenv()));
        logger.log("CONTEXT: " + gson.toJson(context));
        // process event
        logger.log("EVENT: " + gson.toJson(event));
        ServiceComponent dagger = getDaggerServiceComponent();
        dagger.provideUserPoolMapperActivity().handleRequest(event, context);
        return event;
    }
    private ServiceComponent getDaggerServiceComponent() {
        return DaggerServiceComponent.create();
    }
}

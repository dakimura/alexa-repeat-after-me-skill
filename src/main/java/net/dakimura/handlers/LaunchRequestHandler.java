package net.dakimura.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import net.dakimura.text.SpeechText;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.requestType;

/**
 * @author dakimura
 */
public class LaunchRequestHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(requestType(LaunchRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        return input.getResponseBuilder()
                .withSpeech(SpeechText.LAUNCH)
                .withSimpleCard("一言リピート", SpeechText.LAUNCH)
                .withReprompt(SpeechText.REPROMPT)
                .withShouldEndSession(false)
                .build();
    }

}


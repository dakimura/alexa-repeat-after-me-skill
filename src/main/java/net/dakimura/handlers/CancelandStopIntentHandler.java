package net.dakimura.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import net.dakimura.text.SpeechText;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

/**
 * @author dakimura
 */
public class CancelandStopIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.StopIntent").or(intentName("AMAZON.CancelIntent")));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        return input.getResponseBuilder()
                .withSpeech(SpeechText.SESSION_END)
                .withSimpleCard("一言リピート", SpeechText.SESSION_END)
                .build();
    }
}

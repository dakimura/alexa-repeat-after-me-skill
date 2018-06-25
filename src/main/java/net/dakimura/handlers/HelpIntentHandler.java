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
public class HelpIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.HelpIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        return input.getResponseBuilder()
                .withSpeech(SpeechText.SAY_PHRASE)
                .withSimpleCard("一言リピートの使い方", SpeechText.SAY_PHRASE)
                .withReprompt(SpeechText.SAY_PHRASE)
                .build();
    }
}
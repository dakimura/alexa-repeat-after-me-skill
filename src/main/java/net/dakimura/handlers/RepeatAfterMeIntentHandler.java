package net.dakimura.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import net.dakimura.text.SpeechText;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

/**
 * @author dakimura
 */
public class RepeatAfterMeIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("RepeatAfterMeIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Map<String, Slot> slotMap = getSlots(input.getRequestEnvelope().getRequest());

        String speechText = SpeechText.SAY_THAT_AGAIN;

        // speeched phrase, if exist
        Slot phraseSlot = slotMap.get("phrase");
        if (phraseSlot.getValue() != null && !phraseSlot.getValue().equals("")) {
            speechText = phraseSlot.getValue();
        }

        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("一言リピート", speechText)
                .withShouldEndSession(false)
                .withReprompt(SpeechText.REPROMPT)
                .build();
    }

    /**
     * get slot values from request
     *
     * @param request request
     * @return key: slot name, value: Slot object
     */
    private Map<String, Slot> getSlots(@Nonnull Request request) {
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        return intent.getSlots();
    }

}


package net.dakimura;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import net.dakimura.handlers.*;

/**
 * @author dakimura
 */
public class RepeatAfterMeStreamHandler extends SkillStreamHandler {

    // my alexa skill id
    private static final String SKILL_ID = "amzn1.ask.skill.9ad90e96-cc6c-4cba-8205-8ac7d918f163";

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new RepeatAfterMeIntentHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new SessionEndedRequestHandler())
                // my Alexa Skill ID
                .withSkillId(SKILL_ID)
                .build();
    }

    public RepeatAfterMeStreamHandler() {
        super(getSkill());
    }

}


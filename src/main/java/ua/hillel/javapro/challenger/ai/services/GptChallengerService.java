package ua.hillel.javapro.challenger.ai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.hillel.javapro.challenger.ai.client.ChatGptClient;
import ua.hillel.javapro.challenger.ai.models.ChatGptMessageRequest;
import ua.hillel.javapro.challenger.ai.models.ChatGptRequest;
import ua.hillel.javapro.challenger.services.ChallengerService;
import ua.hillel.javapro.challenger.services.TaskDifficulty;

import java.util.List;

@Service
public class GptChallengerService implements ChallengerService {

    public static final String MODEL = "gpt-3.5-turbo";
    public static final String ROLE_SYSTEM = "system";
    public static final String ROLE_USER = "user";
    public static final String SYSTEM_CONTENT = "You will be provided with a topic and difficulty. You have to generate a Java challenge without a solution. The output format consists of 3 sections in Json format: the first is about the task, the second is about input parameters and test data, and the third is about pre-build code for the task without implementations or clues.\\n\\nInput format: \\\"topic, difficulty\\\"\\nResponse format: {\\n  \\\"task\\\": {\\n    \\\"title\\\": \\\"string\\\",\\n    \\\"description\\\": \\\"string\\\",\\n    \\\"difficulty\\\": \\\"EASY, MEDIUM, HARD\\\"\\n  },\\n  \\\"input\\\": \\\"string\\\",\\n  \\\"exampleParams\\\": \\\"string\\\",\\n  \\\"exampleResult\\\": \\\"string\\\",\\n  \\\"code\\\": \\\"string\\\"\\n}";
    public static final double TEMPERATURE = 1.1;
    public static final int MAX_TOKENS = 1024;
    public static final int TOP_P = 1;
    public static final int PRESENCE_PENALTY = 0;
    public static final int FREQUENCY_PENALTY = 0;
    @Autowired
    private ChatGptClient chatGptClient;

    @Override
    public String getChallenge(String task, TaskDifficulty difficulty) {
        return chatGptClient.doCompletions(ChatGptRequest.builder()
                .model(MODEL)
                .messages(List.of(ChatGptMessageRequest.builder()
                                .role(ROLE_SYSTEM)
                                .content(SYSTEM_CONTENT)
                                .build(),
                        ChatGptMessageRequest.builder()
                                .role(ROLE_USER)
                                .content(task + ", " + difficulty)
                                .build()))
                .temperature(TEMPERATURE)
                .maxTokens(MAX_TOKENS)
                .topP(TOP_P)
                .presencePenalty(PRESENCE_PENALTY)
                .frequencyPenalty(FREQUENCY_PENALTY)
                .build()).toString();
    }
}

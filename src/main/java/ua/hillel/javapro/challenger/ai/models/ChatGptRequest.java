package ua.hillel.javapro.challenger.ai.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatGptRequest {

    private String model;

    private List<ChatGptMessageRequest> messages;

    private double temperature;

    @JsonProperty("max_tokens")
    private int maxTokens;

    @JsonProperty("top_p")
    private int topP;

    @JsonProperty("frequency_penalty")
    private int frequencyPenalty;

    @JsonProperty("presence_penalty")
    private int presencePenalty;
}

//{
//        "model": "gpt-3.5-turbo",
//        "messages": [
//        {
//        "role": "system",
//        "content": "You will be provided with a topic and difficulty. You have to generate a Java challenge without a solution. The output format consists of 3 sections in Json format: the first is about the task, the second is about input parameters and test data, and the third is about pre-build code for the task without implementations or clues.\n\nInput format: \"topic, difficulty\"\nResponse format: {\n  \"task\": {\n    \"title\": \"string\",\n    \"description\": \"string\",\n    \"difficulty\": \"EASY, MEDIUM, HARD\"\n  },\n  \"input\": \"string\",\n  \"exampleParams\": \"string\",\n  \"exampleResult\": \"string\",\n  \"code\": \"string\"\n}"
//        },
//        {
//        "role": "user",
//        "content": "OOP, HARD"
//        }
//        ],
//        "temperature": 1.1,
//        "max_tokens": 1024,
//        "top_p": 1,
//        "frequency_penalty": 0,
//        "presence_penalty": 0
//        }

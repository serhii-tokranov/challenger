package ua.hillel.javapro.challenger.ai.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatGptMessageRequest {

    private String role;

    private String content;
}

//        "messages": [
//        {
//        "role": "system",
//        "content": "You will be provided with a topic and difficulty. You have to generate a Java challenge without a solution. The output format consists of 3 sections in Json format: the first is about the task, the second is about input parameters and test data, and the third is about pre-build code for the task without implementations or clues.\n\nInput format: \"topic, difficulty\"\nResponse format: {\n  \"task\": {\n    \"title\": \"string\",\n    \"description\": \"string\",\n    \"difficulty\": \"EASY, MEDIUM, HARD\"\n  },\n  \"input\": \"string\",\n  \"exampleParams\": \"string\",\n  \"exampleResult\": \"string\",\n  \"code\": \"string\"\n}"
//        },
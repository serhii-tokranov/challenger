package ua.hillel.javapro.challenger.ai.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatGptResponse {

    private String id;

    private String object;

    private Long created;

    private String model;

    private List<ChatGptChoiceResponse> choices;

    private ChatGptUsageResponse usage;
}

//{
//        "id": "chatcmpl-7bm6KYjXUb9osYdSZmf82ZdGTzrBZ",
//        "object": "chat.completion",
//        "created": 1689237392,
//        "model": "gpt-3.5-turbo-0613",
//        "choices": [
//        {
//        "index": 0,
//        "message": {
//        "role": "assistant",
//        "content": "{\n  \"task\": {\n    \"title\": \"File Reader\",\n    \"description\": \"Write a Java function that reads the content of a file and returns it as a string. The file path should be provided as a parameter to the function.\",\n    \"difficulty\": \"EASY\"\n  },\n  \"input\": \"The input for the function is a string representing the file path.\",\n  \"exampleParams\": \"\\\"file.txt\\\"\",\n  \"exampleResult\": \"\\\"This is the content of the file.\\\"\",\n  \"code\": \"public class FileReader {\\n\\n  public static String readFile(String filePath) {\\n    // Implement the logic here\\n  }\\n}\""
//        },
//        "finish_reason": "stop"
//        }
//        ],
//        "usage": {
//        "prompt_tokens": 158,
//        "completion_tokens": 134,
//        "total_tokens": 292
//        }
//        }
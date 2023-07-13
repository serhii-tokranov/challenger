package ua.hillel.javapro.challenger.ai.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatGptMessageResponse {

    private String role;

    private String content;
}

//        "message": {
//        "role": "assistant",
//        "content": "{\n  \"task\": {\n    \"title\": \"File Reader\",\n    \"description\": \"Write a Java function that reads the content of a file and returns it as a string. The file path should be provided as a parameter to the function.\",\n    \"difficulty\": \"EASY\"\n  },\n  \"input\": \"The input for the function is a string representing the file path.\",\n  \"exampleParams\": \"\\\"file.txt\\\"\",\n  \"exampleResult\": \"\\\"This is the content of the file.\\\"\",\n  \"code\": \"public class FileReader {\\n\\n  public static String readFile(String filePath) {\\n    // Implement the logic here\\n  }\\n}\""
//        },
package ua.hillel.javapro.challenger.ai.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatGptUsageResponse {

    @JsonProperty("prompt_tokens")
    private int promptTokens;

    @JsonProperty("completion_tokens")
    private int completionTokens;

    @JsonProperty("total_tokens")
    private int totalTokens;
}

//        "usage": {
//        "prompt_tokens": 158,
//        "completion_tokens": 134,
//        "total_tokens": 292
//        }
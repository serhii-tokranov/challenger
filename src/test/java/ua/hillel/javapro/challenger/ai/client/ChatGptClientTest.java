package ua.hillel.javapro.challenger.ai.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;
import ua.hillel.javapro.challenger.ai.models.*;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = "chat-gpt.url=http://localhost:${wiremock.server.port}")
@AutoConfigureWireMock(port = 0)
@ActiveProfiles("test")
public class ChatGptClientTest {

    @Autowired
    private ChatGptClient chatGptClient;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void shouldReturnMockedString() throws JsonProcessingException {
        //given
        ChatGptResponse response = generateChatGptResponse();

        String responseJson = objectMapper.writeValueAsString(response);
        stubFor(post(urlEqualTo("/v1/chat/completions"))
                .willReturn(aResponse()
                        .withHeader("Authorization", "Bearer chat-gpt-secret-token")
                        .withHeader("Content-Type", "application/json")
                        .withBody(responseJson)));
        ChatGptRequest chatGptRequest = generateChatGptRequest();

        //when
        ChatGptResponse result = chatGptClient.doCompletions(chatGptRequest);
        //then
        assertEquals(response, result);
    }

    private static ChatGptRequest generateChatGptRequest() {
        return ChatGptRequest.builder()
                .model("model")
                .messages(List.of(ChatGptMessageRequest.builder()
                        .role("role")
                        .content("content")
                        .build()))
                .temperature(1.0)
                .maxTokens(1024)
                .topP(1)
                .presencePenalty(0)
                .presencePenalty(0)
                .build();
    }

    private static ChatGptResponse generateChatGptResponse() {
        return ChatGptResponse.builder()
                .id("0")
                .object("text")
                .created(1234567L)
                .model("model")
                .choices(List.of(ChatGptChoiceResponse.builder()
                        .index(0)
                        .message(ChatGptMessageResponse.builder()
                                .role("role")
                                .content("content")
                                .build())
                        .finishReason("reason")
                        .build()))
                .usage(ChatGptUsageResponse.builder()
                        .promptTokens(1)
                        .completionTokens(1)
                        .totalTokens(1)
                        .build())
                .build();
    }
}

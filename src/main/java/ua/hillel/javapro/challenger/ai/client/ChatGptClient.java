package ua.hillel.javapro.challenger.ai.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ua.hillel.javapro.challenger.ai.models.ChatGptRequest;
import ua.hillel.javapro.challenger.ai.models.ChatGptResponse;

@FeignClient(name = "chat-gpt", url = "${chat-gpt.url}")
public interface ChatGptClient {

    @PostMapping("/v1/chat/completions")
    ChatGptResponse doCompletions(@RequestBody ChatGptRequest chatGptRequest);
}

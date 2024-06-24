package com.wtf.util.client;

import com.wtf.dto.chatGptDTO.request.ChatGptRequest;
import com.wtf.dto.chatGptDTO.response.ChatGptResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "chatgpt-client", url = "https://api.openai.com")
public interface ChatGPTClient {

    @PostMapping("/v1/chat/completions")
    ChatGptResponse getChatGptResponse(@RequestBody ChatGptRequest request,
                                       @RequestHeader("Authorization") String authorization);
}

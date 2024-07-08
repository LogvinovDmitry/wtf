package com.wtf.client;

import com.wtf.dto.chatGPT.request.ChatGptRequest;
import com.wtf.dto.chatGPT.response.ChatGptResponse;
import com.wtf.util.Constants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "chatgpt-client", url = "${baseUrl.chatGpt}")
public interface ChatGPTClient {

    @PostMapping("/v1/chat/completions")
    ChatGptResponse getChatGptResponse(@RequestBody ChatGptRequest request,
                                       @RequestHeader(Constants.AUTHORIZATION_HEADER) String authorization);
}

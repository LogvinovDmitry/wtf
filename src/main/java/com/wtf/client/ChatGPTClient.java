package com.wtf.client;

import com.wtf.dto.chatGPT.request.ChatGptRequest;
import com.wtf.dto.chatGPT.response.ChatGptResponse;
import com.wtf.util.Constants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//TODO: move feign client base url url to property file
@FeignClient(name = "chatgpt-client", url = "https://api.openai.com")
public interface ChatGPTClient {

    //Тут был Дима
    @PostMapping("/v1/chat/completions")
    ChatGptResponse getChatGptResponse(@RequestBody ChatGptRequest request,
                                       @RequestHeader(Constants.AUTHORIZATION_HEADER) String authorization);
}

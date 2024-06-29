package com.wtf.dto.chatGPT.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wtf.dto.chatGPT.ChatGptMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatGptRequest {
    private String model;
    private List<ChatGptMessage> messages;
    @JsonProperty("max_tokens")
    private int maxTokens;
    @JsonProperty("response_format")
    private ChatGptResponseFormat chatGptResponseFormat;
}



package com.wtf.dto.chatGptDTO.request;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("response_format")
    private ResponseFormat responseFormat;
    private List<Message> messages;
    @JsonProperty("max_tokens")
    private int maxTokens;



}



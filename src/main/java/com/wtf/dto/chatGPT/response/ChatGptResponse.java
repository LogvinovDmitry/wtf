package com.wtf.dto.chatGPT.response;

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
//TODO: keep only necessary fields
public class ChatGptResponse {
    private String id;
    private String object;
    private long created;
    private String model;
    private List<ChatGptResponseChoice> choices;
    private ChatGptResponseUsage usage;
    @JsonProperty("system_fingerprint")
    private String systemFingerprint;

}

package com.wtf.dto.chatGPT.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wtf.dto.chatGPT.ChatGptMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatGptResponseChoice {
    private int index;
    private ChatGptMessage message;

}

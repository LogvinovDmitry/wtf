package com.wtf.dto.chatGPT.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatGptResponse {
    private List<ChatGptResponseChoice> choices;
    private ChatGptResponseUsage usage;
}

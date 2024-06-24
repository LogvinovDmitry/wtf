package com.wtf.dto.chatGptDTO.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Choice {
    private int index;
    private Message message;
    private Object logprobs;
    @JsonProperty("finish_reason")
    private String finishReason;

}

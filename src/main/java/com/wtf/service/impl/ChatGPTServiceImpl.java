package com.wtf.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wtf.client.ChatGPTClient;
import com.wtf.dto.chatGPT.ChatGptRecommendation;
import com.wtf.dto.chatGPT.ChatGptRecommendationList;
import com.wtf.dto.chatGPT.request.ChatGptRequest;
import com.wtf.dto.chatGPT.response.ChatGptResponse;
import com.wtf.dto.chatGPT.response.ChatGptResponseChoice;
import com.wtf.service.ChatGPTService;
import com.wtf.util.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatGPTServiceImpl implements ChatGPTService {

    @Value("${authorizationToken.chatGpt}")
    private String authorizationToken;

    private final ChatGPTClient chatGPTClient;
    private final ObjectMapper objectMapper;

    @Override
    public List<ChatGptRecommendation> getChatGptRecommendations(ChatGptRequest chatGptRequest) {

        ChatGptResponse chatGptResponse = chatGPTClient.getChatGptResponse(chatGptRequest,
                String.format("%s %s", Constants.BEARER, authorizationToken));

        Optional<ChatGptResponseChoice> chatGptResponseChoiceOpt = chatGptResponse.getChoices().stream().findFirst();

        if (chatGptResponseChoiceOpt.isEmpty() || chatGptResponseChoiceOpt.get().getMessage() == null) {
            throw new IllegalStateException("No valid message found in ChatGpt response.");
        }

        //TODO: log ChatGptResponseUsage meta info here

        String recommendationContent = chatGptResponseChoiceOpt.get().getMessage().getContent();
        ChatGptRecommendationList chatGptRecommendationList;
        try {
            chatGptRecommendationList = objectMapper.readValue(recommendationContent, ChatGptRecommendationList.class);
        } catch (JsonProcessingException e) {
            log.error("Could not parse json from chatGPT response", e);
            throw new RuntimeException("Could not parse json from chatGPT response", e);
        }

        return chatGptRecommendationList.getRecommendations();
    }
}

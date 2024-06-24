package com.wtf.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wtf.dto.chatGptDTO.RecommendationMovieByGpt;
import com.wtf.dto.chatGptDTO.RecommendationMovieListByGpt;
import com.wtf.dto.chatGptDTO.request.ChatGptRequest;
import com.wtf.dto.chatGptDTO.response.ChatGptResponse;
import com.wtf.dto.chatGptDTO.response.Choice;
import com.wtf.dto.chatGptDTO.response.Message;
import com.wtf.service.ChatGPTService;
import com.wtf.util.client.ChatGPTClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatGPTServiceImpl implements ChatGPTService {

    @Value("${authorizationToken.chatGpt}")
    private String authorizationToken;

    private final ChatGPTClient chatGPTClient;
    private final ObjectMapper objectMapper;

    @Override
    public List<RecommendationMovieByGpt> getRecommendationMoviesByGpt(
            ChatGptRequest chatGptRequest) throws JsonProcessingException {

        ChatGptResponse chatGptResponse = chatGPTClient
                .getChatGptResponse(chatGptRequest, "Bearer " + authorizationToken);

        List<Choice> choices = chatGptResponse.getChoices();

        String content = null;

        for (Choice choice : choices) {
            Message message = choice.getMessage();

            if (choice.getMessage() != null) {
                content = message.getContent();

                break;
            }
        }

        if (content == null) {
            //logger.error("No valid message found in the response.");
            throw new IllegalStateException("No valid message found in the response.");
        }

        RecommendationMovieListByGpt recommendationMovieListByGpt = objectMapper
                .readValue(content, RecommendationMovieListByGpt.class);

        return recommendationMovieListByGpt.getRecommendationMovieByGptList();

    }
}

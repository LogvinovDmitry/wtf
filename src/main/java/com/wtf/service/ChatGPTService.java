package com.wtf.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wtf.dto.chatGptDTO.RecommendationMovieByGpt;
import com.wtf.dto.chatGptDTO.request.ChatGptRequest;

import java.util.List;

public interface ChatGPTService {

    List<RecommendationMovieByGpt> getRecommendationMoviesByGpt(
            ChatGptRequest chatGptRequest) throws JsonProcessingException;

}

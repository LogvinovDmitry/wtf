package com.wtf.service;

import com.wtf.dto.chatGPT.ChatGptRecommendation;
import com.wtf.dto.chatGPT.request.ChatGptRequest;

import java.util.List;

public interface ChatGPTService {

    List<ChatGptRecommendation> getChatGptRecommendations(ChatGptRequest chatGptRequest);
}

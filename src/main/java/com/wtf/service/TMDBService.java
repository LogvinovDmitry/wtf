package com.wtf.service;

import com.uwetrottmann.tmdb2.entities.Movie;
import com.wtf.dto.chatGPT.ChatGptRecommendation;

import java.util.List;

public interface TMDBService {
    List<Movie> getAllByRecommendations(List<ChatGptRecommendation> chatGptRecommendations);
}

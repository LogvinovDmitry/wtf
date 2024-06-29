package com.wtf.service;

import com.uwetrottmann.tmdb2.entities.Movie;
import com.wtf.dto.chatGPT.request.ChatGptRequest;

import java.util.List;

public interface MovieRecommendationService {
    List<Movie> getRecommendedMovies(ChatGptRequest chatGptRequest);
}

package com.wtf.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.uwetrottmann.tmdb2.entities.Movie;
import com.wtf.dto.chatGptDTO.request.ChatGptRequest;

import java.util.List;

public interface FilmRecommendationService {

    List<Movie> fetchAndValidateRecommendedFilms(ChatGptRequest chatGptRequest) throws JsonProcessingException;
}

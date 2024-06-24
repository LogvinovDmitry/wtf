package com.wtf.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.uwetrottmann.tmdb2.entities.Movie;
import com.wtf.dto.chatGptDTO.request.ChatGptRequest;
import com.wtf.service.FilmRecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/wtf")
public class FilmRecommendationController {

    private final FilmRecommendationService filmRecommendationService;

    @PostMapping("/film-recommendations")
    public List<Movie> getRecommendedFilms(@RequestBody ChatGptRequest chatGptRequest) throws JsonProcessingException {

        return filmRecommendationService.fetchAndValidateRecommendedFilms(chatGptRequest);
    }
}

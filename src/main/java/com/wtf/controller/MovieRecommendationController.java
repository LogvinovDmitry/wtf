package com.wtf.controller;

import com.uwetrottmann.tmdb2.entities.Movie;
import com.wtf.dto.chatGPT.request.ChatGptRequest;
import com.wtf.service.MovieRecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie-recommendation")
public class MovieRecommendationController {
//Проверка
    private final MovieRecommendationService movieRecommendationService;

    @PostMapping("/")
    public List<Movie> recommendedMovies(@RequestBody ChatGptRequest chatGptRequest) {
        return movieRecommendationService.getRecommendedMovies(chatGptRequest);
    }
}

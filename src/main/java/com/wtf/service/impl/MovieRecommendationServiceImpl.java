package com.wtf.service.impl;

import com.uwetrottmann.tmdb2.entities.Movie;
import com.wtf.dto.chatGPT.ChatGptRecommendation;
import com.wtf.dto.chatGPT.request.ChatGptRequest;
import com.wtf.service.ChatGPTService;
import com.wtf.service.MovieRecommendationService;
import com.wtf.service.TMDBService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class MovieRecommendationServiceImpl implements MovieRecommendationService {

    private final ChatGPTService chatGPTService;
    private final TMDBService tmdbService;

    @Override
    public List<Movie> getRecommendedMovies(ChatGptRequest chatGptRequest) {

        List<ChatGptRecommendation> chatGptRecommendations = chatGPTService.getChatGptRecommendations(chatGptRequest);

        log.info("-----------------------------------------------------------");
        chatGptRecommendations.forEach(chatGptRecommendation ->
                log.info("ChatGPT Recommendation: {}", chatGptRecommendation));
        log.info("-----------------------------------------------------------");

        List<Movie> recommendedMovies = tmdbService.getAllByRecommendations(chatGptRecommendations);

        for (Movie movie : recommendedMovies) {
            log.info(
                    movie.title + " " +
                    movie.original_language + " " +
                    movie.id + " " +
                    movie.poster_path
            );
        }

        return recommendedMovies;
    }
}

package com.wtf.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.uwetrottmann.tmdb2.entities.Movie;
import com.wtf.dto.chatGptDTO.RecommendationMovieByGpt;
import com.wtf.dto.chatGptDTO.request.ChatGptRequest;
import com.wtf.service.FilmRecommendationService;
import com.wtf.service.ThemoviedbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FilmRecommendationServiceImpl implements FilmRecommendationService {

    private final ChatGPTServiceImpl chatGPTServiceImpl;
    private final ThemoviedbService themoviedbService;


    @Override
    public List<Movie> fetchAndValidateRecommendedFilms(ChatGptRequest chatGptRequest) throws JsonProcessingException {

        List<RecommendationMovieByGpt> recommendationMovieByGptList = chatGPTServiceImpl.getRecommendationMoviesByGpt(chatGptRequest);

        System.out.println("------------------------------------------------------------");

        for (RecommendationMovieByGpt recommendationMovieByGpt : recommendationMovieByGptList) {
            System.out.println(recommendationMovieByGpt.getName() + " " + recommendationMovieByGpt.getYear() + " " + recommendationMovieByGpt.getTmdbId());
        }

        System.out.println("------------------------------------------------------------");

        List<Movie> moviesFromThemoviedbDTOList = null;
        try {
            moviesFromThemoviedbDTOList = themoviedbService.getMoviesFromThemoviedb(recommendationMovieByGptList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Movie movie : moviesFromThemoviedbDTOList) {
            System.out.println(
                    movie.title + " " +
                    movie.original_language + " " +
                    movie.id + " " +
                    movie.poster_path
            );
        }

        return moviesFromThemoviedbDTOList;
    }
}

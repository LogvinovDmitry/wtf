package com.wtf.service;

import com.uwetrottmann.tmdb2.entities.Movie;
import com.wtf.dto.chatGptDTO.RecommendationMovieByGpt;

import java.io.IOException;
import java.util.List;

public interface ThemoviedbService {

    List<Movie> getMoviesFromThemoviedb(
            List<RecommendationMovieByGpt> recommendationMovieByGptList) throws IOException;

}

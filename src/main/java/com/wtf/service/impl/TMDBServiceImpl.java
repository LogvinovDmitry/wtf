package com.wtf.service.impl;

import com.uwetrottmann.tmdb2.Tmdb;
import com.uwetrottmann.tmdb2.entities.Movie;
import com.wtf.dto.chatGPT.ChatGptRecommendation;
import com.wtf.service.TMDBService;
import com.wtf.util.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TMDBServiceImpl implements TMDBService {

    private final Tmdb tmdb;

    public List<Movie> getAllByRecommendations(List<ChatGptRecommendation> chatGptRecommendations) {

        List<Movie> movies = new ArrayList<>();

        for (ChatGptRecommendation chatGptRecommendation : chatGptRecommendations) {
            try {
                Response<Movie> concreteMovie = tmdb
                        .moviesService()
                        .summary(chatGptRecommendation.getTmdbId(), Constants.LOCALE_EN_US)
                        .execute();
                if (concreteMovie.isSuccessful()) {
                    movies.add(concreteMovie.body());
                }
            } catch (IOException e) {
                log.warn("Could not fetch tmdb movie details for ID {}", tmdb, e);
            }

        }
        return movies;
    }
//TODO: delete if not necessary

//        //Блок с multi
//        //Основное различие заключается в том, что searchService.movie() ищет только фильмы, в то время как
//        //searchService().multi() ищет любые типы объектов, доступных в базе данных TMDb (фильмы, сериалы, персоны).
//        MediaResultsPage resultsPage = tmdb.searchService().multi(query1, null, null, null, null).execute().body();
//
//        //Выводим результаты поиска
//        if (resultsPage != null && resultsPage.results != null) {
//            for (Media result : resultsPage.results) {
//
//                if (result.movie != null) {
//                    String title = result.movie.title;
//                    System.out.println(title);
//                }
//            }
//        }

}

package com.wtf.service.impl;

import com.uwetrottmann.tmdb2.Tmdb;
import com.uwetrottmann.tmdb2.entities.Movie;
import com.wtf.dto.chatGptDTO.RecommendationMovieByGpt;
import com.wtf.service.ThemoviedbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ThemoviedbServiceImpl implements ThemoviedbService {

    private final Tmdb tmdb;

    public List<Movie> getMoviesFromThemoviedb(
            List<RecommendationMovieByGpt> recommendationMovieByGptList) throws IOException {

        List<Movie> movieListFromThemoviedb = new ArrayList<>();

        for (RecommendationMovieByGpt recommendationMovieByGpt : recommendationMovieByGptList) {

            //При необходимости можно добавить информацию о актерах и фото
            //https://api.themoviedb.org/3/movie/77338?api_key=9d01b6fbae0990e0759336c85998ee46&append_to_response=credits,images
            //или в коде (только с ошибкой - аргументы надо через Энамы аргументы вносить):
            //tmdb.moviesService().summary(recommendationMovieByGpt.getTmdbId(), "en-US", new AppendToResponse("credits, images, videos, reviews, similar, recommendations")).execute();

            Response<Movie> movieFromThemoviedb = tmdb.moviesService().summary(recommendationMovieByGpt.getTmdbId()
                    , "en-US").execute();

            if (movieFromThemoviedb.isSuccessful()) {
                movieListFromThemoviedb.add(movieFromThemoviedb.body());
            }
        }

        return movieListFromThemoviedb;
    }

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

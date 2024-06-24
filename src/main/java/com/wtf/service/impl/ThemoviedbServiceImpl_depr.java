//package com.wtf.service.impl;
//
//import com.uwetrottmann.tmdb2.Tmdb;
//import com.uwetrottmann.tmdb2.entities.BaseMovie;
//import com.uwetrottmann.tmdb2.entities.MovieResultsPage;
//import com.wtf.dto.MovieFromThemoviedbDTO;
//import com.wtf.dto.chatGptDTO.RecommendationMovieByGpt;
//import com.wtf.service.ThemoviedbService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class ThemoviedbServiceImpl_depr implements ThemoviedbService {
//
//    private final Tmdb tmdb;
//
//    public List<MovieFromThemoviedbDTO> getMoviesFromThemoviedb(
//            List<RecommendationMovieByGpt> recommendationMovieByGptList) throws IOException {
//
//        List<MovieFromThemoviedbDTO> movieFromThemoviedbDTOList = new ArrayList<>();
//
//        for (RecommendationMovieByGpt recommendationMovieByGpt : recommendationMovieByGptList) {
//
//            MovieResultsPage resultsPage = tmdb.searchService()
//                    .movie(
//                            recommendationMovieByGpt.getName()
//                            , null
//                            , recommendationMovieByGpt.getLanguage()
//                            , recommendationMovieByGpt.getRegion()
//                            , true
//                            , recommendationMovieByGpt.getYear()
//                            , recommendationMovieByGpt.getPrimaryReleaseYear())
//                    .execute().body();
//
//            if (resultsPage != null && resultsPage.results != null) {
//                //assert resultsPage.results != null; //может эта строчка красивее чем блок ИФ?
//                for (BaseMovie result : resultsPage.results) {
//
//                    if (result != null) {
//
//
//                        assert result.title != null;
////                        if (result.title.equals(recommendationMovieByGpt.getName())) {
//
//                        LocalDate releaseDate = result.release_date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//                        int year = releaseDate.getYear();
//                        if (year==(recommendationMovieByGpt.getYear())) {
//
//
//                            String posterUrl = result.poster_path != null ? "https://image.tmdb.org/t/p/w500" + result.poster_path : null;
//
//                            MovieFromThemoviedbDTO movie = MovieFromThemoviedbDTO.builder()
//                                    .id(Long.valueOf(result.id)) // Assuming result.id is not null
//                                    .originalTitle(result.original_title)
//                                    .title(result.title)
//                                    .posterUrl(posterUrl)
//                                    .overview(result.overview)
//                                    .releaseDate(result.release_date)
//                                    .adult(result.adult)
//                                    .originalLanguage(result.original_language)
//                                    .backdropPath(result.backdrop_path)
//                                    .popularity(result.popularity)
//                                    .voteCount(result.vote_count)
//                                    .voteAverage(result.vote_average)
//                                    .genreIds(result.genre_ids)
//                                    .build();
//
//                            movieFromThemoviedbDTOList.add(movie);
//
//                        }
//                    }
//                }
//            }
//
//
//        }
//
//        return movieFromThemoviedbDTOList;
//    }
//
//
////        //Блок с multi
////        //Основное различие заключается в том, что searchService.movie() ищет только фильмы, в то время как
////        //searchService().multi() ищет любые типы объектов, доступных в базе данных TMDb (фильмы, сериалы, персоны).
////        MediaResultsPage resultsPage = tmdb.searchService().multi(query1, null, null, null, null).execute().body();
////
////        //Выводим результаты поиска
////        if (resultsPage != null && resultsPage.results != null) {
////            for (Media result : resultsPage.results) {
////
////                if (result.movie != null) {
////                    String title = result.movie.title;
////                    System.out.println(title);
////                }
////            }
////        }
//
//
//}

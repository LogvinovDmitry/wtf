package com.wtf.service.impl;

import com.uwetrottmann.tmdb2.entities.Movie;
import com.wtf.client.WikidataClient;
import com.wtf.dto.chatGPT.ChatGptRecommendation;
import com.wtf.dto.chatGPT.request.ChatGptRequest;
import com.wtf.dto.wikidata.WikidataResponse;
import com.wtf.service.ChatGPTService;
import com.wtf.service.MovieRecommendationService;
import com.wtf.service.TMDBService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class MovieRecommendationServiceImpl implements MovieRecommendationService {

    private final ChatGPTService chatGPTService;
    private final TMDBService tmdbService;
    private final WikidataClient wikidataClient;

    @Override
    public List<Movie> getRecommendedMovies(ChatGptRequest chatGptRequest) {

        List<ChatGptRecommendation> chatGptRecommendations = chatGPTService.getChatGptRecommendations(chatGptRequest);

        log.info("-----------------------------------------------------------");
        chatGptRecommendations.forEach(chatGptRecommendation ->
                log.info("ChatGPT Recommendation: {} * {} * {}",
                        chatGptRecommendation.getName(),
                        chatGptRecommendation.getYear(),
                        chatGptRecommendation.getTmdbId()));

        log.info("-----------------------------------------------------------");
        List<Movie> recommendedMovies = tmdbService.getAllByRecommendations(chatGptRecommendations);

        recommendedMovies.forEach(recommendedMovie ->
        {
            Date releaseDate = recommendedMovie.release_date;
            //не самое лучшее решение выводить с такой проверкой данные, которые нужны нам только для наглядности...
            assert releaseDate != null : "Release date should not be null";
            LocalDate localDate = releaseDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int year = localDate.getYear();
            log.info("tmdbService: {} * {} * {}",
                    recommendedMovie.title,
                    year,
                    recommendedMovie.id);
        });


        //block for test wikidata-client
        String testId = "Q214801";

        WikidataResponse wikidataResponse = wikidataClient.getWikidataResponse(testId);
        log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        log.info("wikidataResponse: {} * {} * {}",
                wikidataResponse.getId(),
                wikidataResponse.getLabels().getEn(),
                wikidataResponse.getDescriptions().getEn()
        );
        ////////////////////////////////


        return recommendedMovies;
    }
}

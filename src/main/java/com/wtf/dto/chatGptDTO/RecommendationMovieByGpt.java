package com.wtf.dto.chatGptDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecommendationMovieByGpt {
    private String name;
    private int year;
//    private String region;
//    @JsonProperty("primary_release_year")
//    private int primaryReleaseYear;
//    private String language;

    @JsonProperty("tmdb_id")
    private int tmdbId;
}

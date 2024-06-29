package com.wtf.dto.chatGPT;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ChatGptRecommendation {
    private String name;
    private int year;
//    private String region;
//    @JsonProperty("primary_release_year")
//    private int primaryReleaseYear;
//    private String language;

    @JsonProperty("tmdb_id")
    private int tmdbId;
}

package com.wtf.dto.chatGptDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecommendationMovieListByGpt {

    @JsonProperty("recommendations")
    private List<RecommendationMovieByGpt> recommendationMovieByGptList;
}

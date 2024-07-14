package com.wtf.dto.wikidata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WikidataResponse {
    private String id;
    private Descriptions descriptions;
    private Labels labels;
}

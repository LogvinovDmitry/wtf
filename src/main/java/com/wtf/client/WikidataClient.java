package com.wtf.client;

import com.wtf.dto.wikidata.WikidataResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "wikidata-client", url = "${baseUrl.wikidata}")
public interface WikidataClient {

    @GetMapping("{id}")
    WikidataResponse getWikidataResponse(@PathVariable("id") String id);
}

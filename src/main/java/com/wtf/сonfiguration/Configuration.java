package com.wtf.сonfiguration;

import com.uwetrottmann.tmdb2.Tmdb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Value("${themoviedb.apiKey}")
    private String apiKey;

    @Bean
    public Tmdb tmdb() {
        return new Tmdb(apiKey);
    }

    //Пока что нет необходимости в модел мапере
//    @Bean
//    public ModelMapper modelMapper() {
//        ModelMapper modelMapper = new ModelMapper();
//        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
//        return modelMapper;
//    }

}

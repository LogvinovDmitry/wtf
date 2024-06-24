package com.wtf;

import com.uwetrottmann.tmdb2.Tmdb;
import com.uwetrottmann.tmdb2.entities.*;

import com.uwetrottmann.tmdb2.enumerations.MediaType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


import java.io.IOException;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.wtf")
public class WtfApplication {

    public static void main(String[] args) {
        SpringApplication.run(WtfApplication.class, args);
    }

}

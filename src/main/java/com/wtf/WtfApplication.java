package com.wtf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.wtf")
@EnableJpaRepositories


public class WtfApplication {

    public static void main(String[] args) {
        SpringApplication.run(WtfApplication.class, args);
    }

}

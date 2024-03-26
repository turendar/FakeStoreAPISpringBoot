package org.turendar.fakestore3rdpartyapi.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateAPIConfig {
    @Bean
    RestTemplate getRestTemplateObject(){
        return new RestTemplateBuilder().build();
    }
}

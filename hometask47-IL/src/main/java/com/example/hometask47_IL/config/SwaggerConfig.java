package com.example.hometask47_IL.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi groupedOpenApiHotel() {
        return GroupedOpenApi.builder()
                .group("HOTEL GROUP")
                .displayName("HOTEL GROUP DN")
                .pathsToMatch("/hotel/**")
                .build();
    }
}

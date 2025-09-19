package com.example.project_library.config;

import com.example.project_library.dto.ErrorDto;
import com.example.project_library.exc.CommonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Bean
    public ErrorDecoder errorDecoder() {
        return (method, response) -> {
            try (var is = response.body().asInputStream()) {

                var errorAsBytes = is.readAllBytes();

                ObjectMapper mapper = new ObjectMapper();
                var errorDetails = mapper.readValue(errorAsBytes, ErrorDto.class);

                return new CommonException(errorDetails);

            } catch (Exception exc) {

            }
            return new CommonException(new ErrorDto(808000, "Unknown error"));


        };
    }
}
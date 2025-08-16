package com.example.hometask47_IL.config;

import com.example.hometask47_IL.dto.ErrorDto;
import com.example.hometask47_IL.exc.CommonException;
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

            } catch (Exception e) {
            }

            return new CommonException(new ErrorDto(808000, "Unknown error"));
        };
    }

}


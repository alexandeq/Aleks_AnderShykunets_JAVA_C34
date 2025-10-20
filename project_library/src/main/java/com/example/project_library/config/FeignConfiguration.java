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
                ObjectMapper mapper = new ObjectMapper();
                ErrorDto errorDto = mapper.readValue(is, ErrorDto.class);
                return new CommonException(errorDto.getErrorCode(), errorDto.getDetails());
            } catch (Exception e) {
                return new CommonException(808000, "Unknown error");
            }
        };
    }
}


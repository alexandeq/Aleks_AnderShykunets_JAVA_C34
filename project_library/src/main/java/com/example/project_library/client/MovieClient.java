package com.example.project_library.client;

import com.example.project_library.dto.MovieDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "movie-client", url = "http://localhost:8082", path = "/movie")
public interface MovieClient {

    @GetMapping("/all")
    List<MovieDto> getAll();
}

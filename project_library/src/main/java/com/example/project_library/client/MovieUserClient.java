package com.example.project_library.client;

import com.example.project_library.dto.MovieDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "movie-user-client", url = "http://localhost:8082", path = "/movie")
public interface MovieUserClient {

    @GetMapping("/all")
    List<MovieDto> getAll();




}

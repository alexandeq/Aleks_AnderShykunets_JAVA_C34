package com.example.project_library.client;

import com.example.project_library.dto.CommentDto;
import com.example.project_library.dto.MovieDto;
import com.example.project_library.dto.MovieSearchDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "movie-client", url = "http://localhost:8082", path = "/movie")
public interface MovieClient {

    @GetMapping("/all")
    List<MovieDto> getAll();

    @GetMapping("/{id}")
    MovieDto findById(@PathVariable UUID id);

    @PostMapping
    MovieDto create(@RequestBody MovieDto dto);

    @GetMapping("/{id}")
    MovieDto getById(@PathVariable("id") UUID id);


    @PutMapping("/{id}")
    MovieDto edit(@PathVariable("id") UUID id, @RequestBody MovieDto dto);


    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") UUID id);
}

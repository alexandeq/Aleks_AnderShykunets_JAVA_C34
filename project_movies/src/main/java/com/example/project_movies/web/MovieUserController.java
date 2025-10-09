package com.example.project_movies.web;

import com.example.project_movies.dto.MovieDto;
import com.example.project_movies.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieUserController {

    private final MovieService service;


    @GetMapping("/all")
    public List<MovieDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public MovieDto findById(@PathVariable UUID id) {
        return service.findById(id);

    }

}

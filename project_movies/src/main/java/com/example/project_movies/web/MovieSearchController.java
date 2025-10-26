package com.example.project_movies.web;

import com.example.project_movies.domain.MovieEntity;
import com.example.project_movies.dto.MovieDto;
import com.example.project_movies.dto.MovieSearchDto;
import com.example.project_movies.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie/search")
public class MovieSearchController {

    private final MovieService service;

    @PostMapping
    public List<MovieDto> searchMovies(@RequestBody MovieSearchDto dto) {
        return service.search(dto);
    }

}

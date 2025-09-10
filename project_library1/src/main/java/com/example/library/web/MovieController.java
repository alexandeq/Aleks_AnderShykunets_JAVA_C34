package com.example.library.web;

import com.example.library.dto.MovieDto;
import com.example.library.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/all")
    public List<MovieDto> getMovies(){
        return movieService.getMovies();


    }
}

package com.example.project_library.web;
import com.example.project_library.dto.MovieDto;
import com.example.project_library.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {

    private final MovieService service;

    @GetMapping("/all")
    public List<MovieDto> getMovies(){
        return service.getMovies();
    }

    @PostMapping
    public String test1(){
        return "all_movies";
    }

    @GetMapping
    public String test(){
        return "all_movies";
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
    @PostMapping("/user")
    public String user(){
        return "user";
    }

}

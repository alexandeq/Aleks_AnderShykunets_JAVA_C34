package com.example.project_library.web;
import com.example.project_library.dto.MovieDto;
import com.example.project_library.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {

    private final MovieService service;

    @GetMapping("/all")
    public List<MovieDto> getMovies(){
        return service.getMovies();
    }

//    @GetMapping
//    public MovieDto findById(@RequestParam(name = "id") UUID id){
//        return service.findById(id);
//    }


}

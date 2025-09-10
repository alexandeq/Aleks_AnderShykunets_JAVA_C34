package com.example.library.service.impl;

import com.example.library.dto.MovieDto;
import com.example.library.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final RestTemplate restTemplate;

    @Override
    public List<MovieDto> getMovies() {
        var result =  restTemplate.getForObject("http://localhost:8082/movies/all", MovieDto[].class );
        return Arrays.stream(result).collect(Collectors.toList());


    }
}

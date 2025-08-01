package com.example.web.service;

import com.example.web.domain.MovieDto;
import com.example.web.domain.MovieSearchDto;

import java.util.List;

public interface MovieService {

    void save(MovieDto dto);

    List<MovieDto> findAll();

    List<MovieDto> findByTitle(MovieSearchDto dto);
}

package com.example.project_library.service;

import com.example.project_library.dto.CommentDto;
import com.example.project_library.dto.MovieDto;

import java.util.List;
import java.util.UUID;

public interface MovieService {

    List<MovieDto> getMovies();

    MovieDto findById(UUID id);



}

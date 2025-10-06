package com.example.project_movies.service;

import com.example.project_movies.domain.CommentEntity;
import com.example.project_movies.domain.MovieEntity;
import com.example.project_movies.dto.CommentDto;
import com.example.project_movies.dto.MovieDto;
import com.example.project_movies.dto.MovieSearchDto;

import java.util.List;
import java.util.UUID;

public interface MovieService {

    MovieDto save(MovieDto dto);

    List<MovieDto> findAll();

    void delete(UUID id);

    MovieDto findById(UUID id);

    MovieDto editByIdByAdmin(UUID id, MovieDto dto);

    List<CommentDto> getComments(UUID movieId);

    CommentDto addComment(UUID movieId, CommentDto dto);

    List<CommentDto> findByMovieId(UUID movieId);

//    List<MovieDto> findByYearBetween(MovieSearchDto dto);
//
//    List<MovieDto> findByRatingGreaterThanEqual(MovieSearchDto dto);

    List<MovieDto> search(MovieSearchDto dto);









}

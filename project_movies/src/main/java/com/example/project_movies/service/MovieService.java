package com.example.project_movies.service;

import com.example.project_movies.dto.CommentDto;
import com.example.project_movies.dto.MovieDto;

import java.util.List;
import java.util.UUID;

public interface MovieService {

    MovieDto save(MovieDto dto);

    List<MovieDto> findAll();

    void delete(UUID id);

    MovieDto findById(UUID id);

    MovieDto updateByIdByAdmin(UUID id, MovieDto dto);

    List<CommentDto> getComments(UUID movieId);

    //List<CommentDto> getCommentsByMovie(UUID movieId);

    CommentDto addComment(UUID movieId, CommentDto dto);

    List<CommentDto> findByMovieId(UUID movieId);



}

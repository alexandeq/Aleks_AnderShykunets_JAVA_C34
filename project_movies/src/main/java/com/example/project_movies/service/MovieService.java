package com.example.project_movies.service;

import com.example.project_movies.domain.CommentEntity;
import com.example.project_movies.domain.MovieEntity;
import com.example.project_movies.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    List<MovieDto> search(MovieSearchDto dto);

    byte[] getPoster(UUID movieId);

    MovieDto getMovieDetails(UUID movieId);

    PosterDto addPoster(UUID movieId, MultipartFile posterFile) throws IOException;

    List<MovieDto> findPageable(PageDto dto);








}

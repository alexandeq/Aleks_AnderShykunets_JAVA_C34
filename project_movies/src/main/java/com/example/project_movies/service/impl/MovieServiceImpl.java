package com.example.project_movies.service.impl;
import com.example.project_movies.domain.CommentEntity;
import com.example.project_movies.domain.MovieEntity;
import com.example.project_movies.dto.CommentDto;
import com.example.project_movies.dto.MovieDto;
import com.example.project_movies.exc.MovieCommonException;
import com.example.project_movies.mapper.CommentMapper;
import com.example.project_movies.mapper.MovieMapper;

import com.example.project_movies.repository.CommentRepository;
import com.example.project_movies.repository.MovieRepository;
import com.example.project_movies.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepo;
    private final CommentRepository commentRepo;
    private final MovieMapper movieMapper;
    private final CommentMapper commentMapper;



    @Override
    public MovieDto save(MovieDto dto) {
        var entity = movieMapper.toEntity(dto);
        var result =  movieRepo.save(entity);
        return movieMapper.toDto(result);
    }

    @Override
    public List<MovieDto> findAll() {
        return movieMapper.toDtos(movieRepo.findAll());
    }

    @Override
    public MovieDto findById(UUID id) {
        var entity = movieRepo.findById(id)
                .orElseThrow(() -> new MovieCommonException(808202, "Movie with this ID not found"));

        return movieMapper.toDto(entity);
    }



    @Override
    public MovieDto updateByIdByAdmin(UUID id, MovieDto dto) {
        var existingEntity = movieRepo.findById(id).get();

        existingEntity.setTitle(dto.getTitle());
        existingEntity.setRating(dto.getRating());
       // existingEntity.setComment(dto.getComment());
        existingEntity.setYear(dto.getYear());

        var result = movieRepo.save(existingEntity);
        return movieMapper.toDto(result);
    }
    @Override
    public CommentDto addComment(UUID movieId, CommentDto dto) {
        MovieEntity movie = movieRepo.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        CommentEntity entity = commentMapper.toEntity(dto);
        entity.setMovie(movie); // привязка к фильму

        CommentEntity saved = commentRepo.save(entity);
        return commentMapper.toDto(saved);
    }
    @Override
    public List<CommentDto> findByMovieId(UUID movieId) {
        return commentMapper.toDtos(commentRepo.findByMovieId(movieId));
    }
    @Override
    public List<CommentDto> getComments(UUID movieId) {
        return commentMapper.toDtos(commentRepo.findByMovieId(movieId));
    }


    @Override
    public void delete(UUID id) {
        var entity = movieRepo.findById(id)
                .orElseThrow(() -> new MovieCommonException(808201, " delete failed: movie with this ID not found"));

        movieRepo.delete(entity);

        movieMapper.toDto(entity);
    }
}

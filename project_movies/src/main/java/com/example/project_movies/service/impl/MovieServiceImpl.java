package com.example.project_movies.service.impl;

import com.example.project_movies.dto.MovieDto;
import com.example.project_movies.exc.MovieCommonException;
import com.example.project_movies.mapper.MovieMapper;
import com.example.project_movies.repository.MovieRepository;
import com.example.project_movies.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository repo;
    private final MovieMapper mapper;

    @Override
    public MovieDto save(MovieDto dto) {
        var entity = mapper.toEntity(dto);
        var result =  repo.save(entity);
        return mapper.toDto(result);
    }

    @Override
    public List<MovieDto> findAll() {
        return mapper.toDtos(repo.findAll());
    }

    @Override
    public MovieDto findById(UUID id) {
        var entity = repo.findById(id)
                .orElseThrow(() -> new MovieCommonException(808202, "Movie with this ID not found"));

        return mapper.toDto(entity);
    }



    @Override
    public MovieDto updateByIdByAdmin(UUID id, MovieDto dto) {
        var existingEntity = repo.findById(id).get();

        existingEntity.setName(dto.getName());
        existingEntity.setRating(dto.getRating());
        existingEntity.setComment(dto.getComment());
        existingEntity.setYear(dto.getYear());

        var result = repo.save(existingEntity);
        return mapper.toDto(result);
    }

    @Override
    public MovieDto sendCommentByUser(UUID id, MovieDto dto) {
        var existingEntity = repo.findById(id).get();

        existingEntity.setRating(dto.getRating());
        existingEntity.setComment(dto.getComment());

        var result = repo.save(existingEntity);
        return mapper.toDto(result);

    }

    @Override
    public void delete(UUID id) {
        var entity = repo.findById(id)
                .orElseThrow(() -> new MovieCommonException(808201, " delete failed: movie with this ID not found"));

        repo.delete(entity);

        mapper.toDto(entity);
    }
}

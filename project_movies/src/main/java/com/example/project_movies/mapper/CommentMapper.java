package com.example.project_movies.mapper;

import com.example.project_movies.domain.CommentEntity;
import com.example.project_movies.domain.MovieEntity;
import com.example.project_movies.dto.CommentDto;
import com.example.project_movies.dto.MovieDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(source = "movie.id", target = "movieId")  // берём id из movie
    CommentDto toDto(CommentEntity entity);

    @Mapping(source = "movieId", target = "movie.id")  // кладём id в movie
    CommentEntity toEntity(CommentDto dto);

    List<CommentDto> toDtos(List<CommentEntity> entities);

   //List<CommentEntity> toEntities(List<CommentDto> dtos);




    }

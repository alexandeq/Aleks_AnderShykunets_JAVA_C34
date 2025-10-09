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

    @Mapping(source = "movie.id", target = "movieId")
    CommentDto toDto(CommentEntity entity);

    @Mapping(source = "movieId", target = "movie.id")
    CommentEntity toEntity(CommentDto dto);

    List<CommentDto> toDtos(List<CommentEntity> entities);

}

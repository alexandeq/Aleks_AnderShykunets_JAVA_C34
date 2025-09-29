package com.example.project_movies.mapper;

import com.example.project_movies.domain.MovieEntity;
import com.example.project_movies.dto.MovieDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = CommentMapper.class)
public interface MovieMapper {

    MovieDto toDto(MovieEntity entity);

    MovieEntity toEntity(MovieDto dto);

    List<MovieDto> toDtos(List<MovieEntity> entities);
}

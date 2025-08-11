package com.example.web.mapper;

import com.example.web.domain.MovieDto;
import com.example.web.entity.MovieEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    MovieEntity toEntity(MovieDto dto);

    MovieDto toDto(MovieEntity entity);

    List<MovieDto> toDto(List<MovieEntity> entities);

}

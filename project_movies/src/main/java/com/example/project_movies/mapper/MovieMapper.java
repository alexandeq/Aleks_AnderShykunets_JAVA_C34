package com.example.project_movies.mapper;

import com.example.project_movies.domain.MovieEntity;
import com.example.project_movies.dto.MovieDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = CommentMapper.class)
public interface MovieMapper {


    @Mapping(target = "poster", ignore = true) // ✅ игнорируем
    MovieEntity toEntity(MovieDto dto);

    @Mapping(target = "posterUrl",
            expression = "java(entity.getPoster() != null ? \"/movie/\" + entity.getId() + \"/poster\" : null)")
    MovieDto toDto(MovieEntity entity);

    List<MovieDto> toDtos(List<MovieEntity> entities);
}

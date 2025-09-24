package com.example.project_movies.mapper;

import com.example.project_movies.domain.CommentEntity;
import com.example.project_movies.domain.MovieEntity;
import com.example.project_movies.dto.CommentDto;
import com.example.project_movies.dto.MovieDto;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface CommentMapper {

        CommentDto toDto(CommentEntity entity);

        CommentEntity toEntity(CommentDto dto);

        List<CommentDto> toDtos(List<CommentEntity> entities);


    }

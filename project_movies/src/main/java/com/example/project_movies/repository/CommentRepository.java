package com.example.project_movies.repository;

import com.example.project_movies.domain.CommentEntity;
import com.example.project_movies.domain.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<CommentEntity, UUID> {

    CommentEntity save(CommentEntity entity);

    List<CommentEntity> findByMovieId(UUID movieId);



}

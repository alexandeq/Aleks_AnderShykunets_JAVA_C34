package com.example.project_movies.repository;

import com.example.project_movies.domain.CommentEntity;
import com.example.project_movies.domain.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<MovieEntity, UUID> {

    CommentEntity save(CommentEntity entity);


}

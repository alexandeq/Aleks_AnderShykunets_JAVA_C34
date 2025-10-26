package com.example.project_movies.repository;

import com.example.project_movies.domain.MovieEntity;
import com.example.project_movies.domain.PosterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovieRepository extends JpaSpecificationExecutor<MovieEntity>,  JpaRepository<MovieEntity, UUID> {

    List<MovieEntity> findAll();

    Optional<MovieEntity> findById(UUID movieId);

}

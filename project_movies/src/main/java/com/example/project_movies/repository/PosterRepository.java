package com.example.project_movies.repository;

import com.example.project_movies.domain.MovieEntity;
import com.example.project_movies.domain.PosterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;
import java.util.UUID;

public interface PosterRepository extends JpaRepository<PosterEntity, UUID> {

    Optional<PosterEntity> findByMovieId(UUID movieId);


}

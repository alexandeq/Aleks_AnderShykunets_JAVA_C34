package com.example.project_movies.repository;

import com.example.project_movies.domain.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovieRepository extends JpaSpecificationExecutor<MovieEntity>,  JpaRepository<MovieEntity, UUID> {

    List<MovieEntity> findAll();

    List<MovieEntity> findMovieByTitleLike(String title);

    List<MovieEntity> findByYearBetween(Integer from, Integer to) ;

    List<MovieEntity> findByRatingGreaterThanEqual(Integer rating);




}

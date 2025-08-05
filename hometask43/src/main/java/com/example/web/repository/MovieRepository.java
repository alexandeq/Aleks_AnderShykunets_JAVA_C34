package com.example.web.repository;

import com.example.web.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface MovieRepository extends JpaRepository <MovieEntity, UUID>, JpaSpecificationExecutor<MovieEntity> {

}

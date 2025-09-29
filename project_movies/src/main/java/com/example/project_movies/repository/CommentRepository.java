package com.example.project_movies.repository;

import com.example.project_movies.domain.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<CommentEntity, UUID> {

    CommentEntity save(CommentEntity entity);

    List<CommentEntity> findByMovieId(UUID movieId);

    @Query("SELECT AVG(c.rating) FROM CommentEntity c WHERE c.movie.id = :movieId")
    Double getAverageRatingByMovieId(@Param("movieId") UUID movieId);


}

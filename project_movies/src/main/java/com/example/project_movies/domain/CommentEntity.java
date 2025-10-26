package com.example.project_movies.domain;

import com.example.project_movies.domain.MovieEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;


@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CommentEntity {

    @Id
    @UuidGenerator
    private UUID id;

    private String comment;
    private double rating;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private MovieEntity movie;

    public CommentEntity(String comment, double rating, MovieEntity movie) {
        this.comment = comment;
        this.rating = rating;
        this.movie = movie;
    }
}

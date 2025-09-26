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

    @Column(columnDefinition = "TEXT")
    private String comment;

    private Integer rating; // 1–10


    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;
}
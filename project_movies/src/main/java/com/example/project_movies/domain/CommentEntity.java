package com.example.project_movies.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;
}
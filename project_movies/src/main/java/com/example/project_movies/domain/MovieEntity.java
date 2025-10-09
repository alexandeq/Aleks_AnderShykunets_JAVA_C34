package com.example.project_movies.domain;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Lob;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table(name = "movies")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter

public class MovieEntity {

    @Id
    @UuidGenerator
    private UUID id;

    private String title;

    private int year;

    private String description;

    private double rating;

    @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private PosterEntity poster;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CommentEntity> comments = new ArrayList<>();

}


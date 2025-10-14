package com.example.project_movies.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "posters")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PosterEntity {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "image", nullable = false)
    private byte[] image;

    @OneToOne
    @JoinColumn(name = "movie_id", nullable = false, unique = true)
    private MovieEntity movie;
}

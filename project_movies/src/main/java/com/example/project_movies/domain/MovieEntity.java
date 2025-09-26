package com.example.project_movies.domain;

import com.example.project_movies.dto.CommentDto;
import jakarta.persistence.*;
import lombok.*;
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

    //@Column(columnDefinition = "TEXT")
    private String description;

    private Double rating; // Средний рейтинг, обновляется при добавлении комментариев

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CommentEntity> comments = new ArrayList<>();

}

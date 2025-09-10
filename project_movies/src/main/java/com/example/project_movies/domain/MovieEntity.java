package com.example.project_movies.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

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

    private String name;
    private Integer rating;
    private String comment;
    private Integer year;
    //картинка

}

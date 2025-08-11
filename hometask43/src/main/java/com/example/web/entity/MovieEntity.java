package com.example.web.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Table(name="movies")
@Entity
@NoArgsConstructor
@Getter @Setter
public class MovieEntity {

    @Id
    @UuidGenerator
    private UUID id;

    private String title;
    private Integer rating;

}

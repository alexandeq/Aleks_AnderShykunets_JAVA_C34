package org.example.onetomany.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookEntity {


    @Id
    @UuidGenerator
    private UUID id;

    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    @ToString.Exclude
    private AuthorEntity author;

    public BookEntity(String title) {
        this.title = title;
    }
}

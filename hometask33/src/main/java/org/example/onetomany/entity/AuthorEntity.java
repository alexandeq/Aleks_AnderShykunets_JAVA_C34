package org.example.onetomany.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "authors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AuthorEntity {

    @Id
    @UuidGenerator
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<BookEntity> books;

    public AuthorEntity(String name) {
        this.name = name;
    }

    public void addBook(BookEntity book){
        if(books == null) {
            books = new ArrayList<>();
        }

        books.add(book);
        book.setAuthor(this);

    }
}

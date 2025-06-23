package org.example.onetomany;

import org.example.onetomany.entity.AuthorEntity;
import org.example.onetomany.entity.BookEntity;
import org.example.onetomany.service.AuthorService;
import org.example.onetomany.service.BookService;

import java.util.UUID;

public class MainApp {

    private static final AuthorService service = new AuthorService();
    private static final BookService bookService = new BookService();

    public static void main(String[] args) {

        BookEntity book1 = new BookEntity("Under the dome");
        BookEntity book2 = new BookEntity("11/22/63");

        AuthorEntity author = new AuthorEntity("Stephen King");

        author.addBook(book1);
        author.addBook(book2);

        var save = service.save(author);

        var byId = bookService.getById(book1.getId());

        var person =  service.findByIdWithBooks(UUID.fromString("313654e7-e818-4915-9bec-0169bbf63019"));

        System.out.println(person.getBooks().get(1).getTitle());
        System.out.println(byId);

    }
}

package org.example.onetomany.service;

import org.example.config.HibernateFactory;
import org.example.onetomany.entity.AuthorEntity;
import org.example.onetomany.entity.BookEntity;
import org.hibernate.SessionFactory;

import java.util.UUID;

public class BookService {
    private static final SessionFactory factory = HibernateFactory.getSessionFactory();

    public BookEntity getById (UUID id){

        var session = factory.openSession();
        var transaction = session.beginTransaction();

        var entity = session.find(BookEntity.class, id);

        transaction.commit();
        session.close();

        return entity;
    }
}


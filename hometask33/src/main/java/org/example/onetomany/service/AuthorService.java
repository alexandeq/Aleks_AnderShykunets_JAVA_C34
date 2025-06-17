package org.example.onetomany.service;

import org.example.config.HibernateFactory;
import org.example.onetomany.entity.AuthorEntity;
import org.hibernate.SessionFactory;

import java.util.UUID;

public class AuthorService {

    private static final SessionFactory factory = HibernateFactory.getSessionFactory();

    public AuthorEntity save(AuthorEntity authorEntity){

        var session = factory.openSession();
        var transaction = session.beginTransaction();

        session.persist(authorEntity);

        transaction.commit();
        session.close();

        return authorEntity;
    }

    public AuthorEntity findById(UUID id) {

        var session = factory.openSession();
        var transaction = session.beginTransaction();

        var entity = session.find(AuthorEntity.class, id);

        transaction.commit();
        session.close();

        return entity;
    }

    public AuthorEntity findByIdWithBooks(UUID id) {

        var session = factory.openSession();
        var transaction = session.beginTransaction();

        var entity = session.find(AuthorEntity.class, id);
        entity.getBooks().get(1);

        transaction.commit();
        session.close();

        return entity;
    }
}


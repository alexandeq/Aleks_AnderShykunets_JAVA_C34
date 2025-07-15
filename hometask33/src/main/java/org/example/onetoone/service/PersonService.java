package org.example.onetoone.service;

import org.example.config.HibernateFactory;
import org.example.onetoone.entity.PersonEntity;
import org.hibernate.SessionFactory;

import java.util.UUID;

public class PersonService {

    private static final SessionFactory factory = HibernateFactory.getSessionFactory();

    public PersonEntity save(PersonEntity personEntity){

        var session = factory.openSession();
        var transaction = session.beginTransaction();

        session.persist(personEntity);

        transaction.commit();
        session.close();

        return personEntity;
    }

    public PersonEntity findById(UUID id) {
        var session = factory.openSession();
        var transaction = session.beginTransaction();

        var entity = session.find(PersonEntity.class, id);

        transaction.commit();
        session.close();

        return entity;
    }
}

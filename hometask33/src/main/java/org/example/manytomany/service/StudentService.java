package org.example.manytomany.service;

import org.example.config.HibernateFactory;
import org.example.manytomany.entity.StudentEntity;
import org.example.onetomany.entity.AuthorEntity;
import org.hibernate.SessionFactory;

import java.util.UUID;

public class StudentService {

    private static final SessionFactory factory = HibernateFactory.getSessionFactory();

    public StudentEntity save(StudentEntity studentEntity) {

        var session = factory.openSession();
        var transaction = session.beginTransaction();

        session.persist(studentEntity);

        transaction.commit();
        session.close();

        return studentEntity;
    }

    public StudentEntity findById(UUID id) {

        var session = factory.openSession();
        var transaction = session.beginTransaction();

        var entity = session.find(StudentEntity.class, id);

        transaction.commit();
        session.close();

        return entity;
    }
}
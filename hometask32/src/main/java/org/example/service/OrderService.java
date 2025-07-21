package org.example.service;

import org.example.config.HibernateFactory;
import org.example.entity.OrderEntity;
import org.hibernate.SessionFactory;
import java.util.UUID;

public class OrderService {

    private static final SessionFactory factory = HibernateFactory.getSessionFactory();

    public OrderEntity save(OrderEntity orderEntity){

        var session = factory.openSession();
        var transaction = session.beginTransaction();

        session.persist(orderEntity);

        transaction.commit();
        session.close();

        return orderEntity;
    }

    public OrderEntity getById(UUID id){

        var session = factory.openSession();
        var transaction = session.beginTransaction();

        var entity = session.find(OrderEntity.class, id);

        transaction.commit();
        session.close();

        return entity;
    }

}


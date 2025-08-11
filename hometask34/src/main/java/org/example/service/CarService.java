package org.example.service;

import org.example.config.HibernateFactory;
import org.example.dto.SearchDto;
import org.example.entity.CarEntity;
import org.hibernate.SessionFactory;
import org.hibernate.query.criteria.JpaPredicate;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    private static final SessionFactory factory = HibernateFactory.getSessionFactory();

    public CarEntity save(CarEntity carEntity) {

        var session = factory.openSession();
        var transaction = session.beginTransaction();

        session.persist(carEntity);

        transaction.commit();
        session.close();

        return carEntity;
    }

    public List<CarEntity> search(SearchDto searchDto){

        var session = factory.openSession();
        var transaction = session.beginTransaction();

        var builder = session.getCriteriaBuilder();
        var query = builder.createQuery(CarEntity.class);
        var root = query.from(CarEntity.class);

        List<JpaPredicate> predicates = new ArrayList<>();

        if(searchDto.getBrand() != null){
            predicates.add(builder.equal(root.get("brand"), searchDto.getBrand()));
        }
        if(searchDto.getMinPrice() != null){
            predicates.add(builder.greaterThanOrEqualTo(root.get("price"), searchDto.getMinPrice()));
        }
        if(searchDto.getMaxPrice() != null){
            predicates.add(builder.lessThanOrEqualTo(root.get("price"), searchDto.getMaxPrice()));
        }
        if(searchDto.getMinMileage() != null){
            predicates.add(builder.greaterThanOrEqualTo(root.get("mileage"), searchDto.getMinMileage()));
        }
        if(searchDto.getMaxMileage() != null){
            predicates.add(builder.lessThanOrEqualTo(root.get("mileage"), searchDto.getMaxMileage()));
        }
        if(searchDto.getMinYear() != null){
            builder.greaterThanOrEqualTo(root.get("year"), searchDto.getMinYear());
        }

        query.where(predicates.toArray(new JpaPredicate[0]));

        var result = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();
        return result;
    }
}

package org.example.config;

import org.example.manytomany.entity.CourseEntity;
import org.example.manytomany.entity.StudentEntity;
import org.example.onetomany.entity.AuthorEntity;
import org.example.onetomany.entity.BookEntity;
import org.example.onetoone.entity.PassportEntity;
import org.example.onetoone.entity.PersonEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateFactory {

    public static SessionFactory getSessionFactory() {

        Properties properties = new Properties();
        properties.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
        properties.put("hibernate.connection.username", "postgres");
        properties.put("hibernate.connection.password", "postgres");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

        properties.put("hibernate.hbm2ddl.auto", "none");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");

        Configuration configuration = new Configuration()
                .addAnnotatedClass(PersonEntity.class)
                .addAnnotatedClass((PassportEntity.class))
                .addAnnotatedClass(AuthorEntity.class)
                .addAnnotatedClass(BookEntity.class)
                .addAnnotatedClass(StudentEntity.class)
                .addAnnotatedClass(CourseEntity.class)
                .addProperties(properties);

        return configuration.buildSessionFactory();
    }
}

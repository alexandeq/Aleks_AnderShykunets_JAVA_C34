package org.example.config;

import org.example.entity.CarEntity;
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
                    .addAnnotatedClass(CarEntity.class)
                    .addProperties(properties);

            return configuration.buildSessionFactory();
        }
}
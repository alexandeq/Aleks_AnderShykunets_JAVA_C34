package org.example.config;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConfig {

    private final static String JDBC_URl = "jdbc:postgresql://localhost:5432/postgres";
    private final static String USER = "postgres";
    private final static String PASSWORD = "postgres";

    @SneakyThrows
    public static Connection getConection(){
        return DriverManager
                .getConnection(JDBC_URl, USER, PASSWORD);
    }

}

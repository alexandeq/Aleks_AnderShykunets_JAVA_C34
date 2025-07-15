package org.example;

import org.example.domain.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

        List<Person> persons = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = in.nextLine();
        System.out.print("Введите пол(M/W): ");
        String sex = in.nextLine();
        System.out.print("Введите размер одежды(S/M/L/XL): ");
        String size = in.nextLine();
        System.out.println("Имя: " + name + "," + " Пол: " + sex + "," + " Размер: " + size + "." +"\n");
        in.close();

        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1122")) {

            PreparedStatement preparedStatement = connection.prepareStatement("insert into persons (name, sex,size) values (?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, sex);
            preparedStatement.setString(3, size);

            preparedStatement.execute();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from persons");

            while (resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setSex(resultSet.getString("sex"));
                person.setSize(resultSet.getString("size"));

                persons.add(person);
            }

        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
        }

        System.out.println(persons);


    }
}





package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {


////
//        User user1 = new User("login1", 52, "alex");
//        User user2 = new User("login2");
//        User user3 = new User("login3");
//        User user4 = new User("login4");
//
//        Set<User> users = new HashSet<>();
//
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
//        users.add(user4);
//        System.out.println(user1.getLogin());


        Map<String, User> usersList = new HashMap<>();

        usersList.put("login1",new User("Jonh", "Smith", 52 ));



        System.out.println(usersList);



    }
}
//Есть коллекция пользователей. У каждого пользователя есть уникально поле - login.
// Необходимо на основе данной коллекции создать map где ключ - это логин, а значение сам объект пользователь.
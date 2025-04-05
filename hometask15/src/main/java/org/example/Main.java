package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Есть коллекция пользователей. У каждого пользователя есть уникально поле - login.
// Необходимо на основе данной коллекции создать map где ключ - это логин, а значение сам объект пользователь.

        User user1 = new User("log1");
        Set<User> users = new HashSet<>();
        users.add(user1);

        Map<User, User1> usersList = new HashMap<>();
        usersList.put(user1, new User1("lol", "kek"));
//
//
        System.out.println(usersList);


//        List<Login> users = List.of(
//                new Login("log1"),
//                new Login("log2"),
//                new Login("log3"),
//                new Login("log4"));



//
//
//        usersList.put(new Login("log1"), new User("awfaag", "fessvsv"));
//
//        System.out.println(usersList);


//                new User("Ben", "Affleck",List.of(
//                        new Login("log1"))),
//
//                new User("Ben", "Affleck",List.of(
//                        new Login("log2"))),
//
//                new User("Ben", "Affleck",List.of(
//                        new Login("log3"))));







//                new Login("login1"), List.of(
//                        new User("Brad", "Pit", new Login("log1")))
//        );
//
//        List.of(
//                new Login("login2"), List.of(
//                        new User("Matt", "Daemon", new Login("log1")))
//        );
//        List.of(
//                new Login("login3"), List.of(
//                        new User("Tom", "Hanks", new Login("log1")))
//        );


//        User1 user1 = new User1("login1");
//        User1 user2 = new User1("login2");
//        User1 user3 = new User1("login3");
//        User1 user4 = new User1("login4");
////

////
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
//        users.add(user4);
//        Set<Login> users = new HashSet<>();
//        Map<Set<Login>, User> usersList = new HashMap<>();
//
//
//        usersList.put(Set< Login > new Login("login1"), new User("lf", "wf",78));
//        usersList.put("login2", new User("Brad", "Pit", 52));
//        usersList.put("login3",new User("Jeniffer", "Lopez", 52 ));
//        usersList.put("login4",new User("Matt", "Daemon", 52 ));

//        System.out.println(usersList);

    }
}

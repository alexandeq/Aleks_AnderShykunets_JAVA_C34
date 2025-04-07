package org.example.task1;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        User user1 = new User("Ben", "Affleck");
        User user2 = new User("Matt", "Daemon");
        User user3 = new User("Brad", "Pit");


        Set<User> users = new HashSet<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        Map<String, User> usersList = new HashMap<>();
        usersList.put("login1", user1);
        usersList.put("login2", user1);
        usersList.put("login3", user1);

        System.out.println(usersList);


    }
}

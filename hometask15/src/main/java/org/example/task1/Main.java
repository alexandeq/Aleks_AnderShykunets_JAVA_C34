package org.example.task1;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //1) Есть коллекция пользователей.
        // У каждого пользователя есть уникально поле - login.
        // Необходимо на основе данной коллекции создать map где ключ - это логин,
        // а значение сам объект пользователь.

        //по условию у тебя есть коллекция пользователей
        //и ты должен пройти по ней и создать map


        User user1 = new User("Ben");
        User user2 = new User("Matt");

        Set<User> users = new HashSet<>();
        users.add(user1);
        users.add(user2);

        Map<String, User> usersList = new HashMap<>();
        usersList.put(user1.getLogin(), user1);
        usersList.put(user2.getLogin(), user2);

        for(Map.Entry<String, User> pair: usersList.entrySet()){
            String key = pair.getKey();
            User value = pair.getValue();

        System.out.println("key is: " + pair.getKey() + " ; " + "value is: " + pair.getValue() );


       }
    }
}

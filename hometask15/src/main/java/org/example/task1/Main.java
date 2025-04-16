package org.example.task1;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<String, User> usersMap = new HashMap<>();
        Set<User> usersSet = Set.of(
                new User("Benlogin"),
                new User("Mattlogin"),
                new User("Bradlogin"));

        for (User user : usersSet) {
            usersMap.put(user.getLogin(), user);
        }

        for (Map.Entry<String, User> pair : usersMap.entrySet()) {
            System.out.println("key is: " + pair.getKey() + " ; " + "value is: " + pair.getValue());


        }
    }
}

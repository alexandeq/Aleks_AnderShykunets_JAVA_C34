package org.example.task2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainApp {
    public static void main(String[] args) {

        Map<String, Integer> words = new HashMap<>();
        String[] arr = {"one", "two", "three", "four", "five"};

        for (String value : arr) {
            words.put(value, value.length());
        }

        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            System.out.println("Key - " + entry.getKey() + " : " + "value - " + entry.getValue());
        }


    }
}
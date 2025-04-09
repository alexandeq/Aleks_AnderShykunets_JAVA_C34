package org.example.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainApp {
    public static void main(String[] args) {

        String[] arr = {"one", "two", "three", "four", "five"};

        Map<String,Integer> words = new HashMap<>();
        words.put(arr[0],arr[0].length());
        words.put(arr[1],arr[1].length());
        words.put(arr[2],arr[2].length());
        words.put(arr[3],arr[3].length());
        words.put(arr[4],arr[4].length());


        Set<String> keys = words.keySet();

        for (String key : keys) {
            Integer length = words.get(key);
            System.out.println("Key - " + key + " : " + "length - "+ length);
        }


    }
}


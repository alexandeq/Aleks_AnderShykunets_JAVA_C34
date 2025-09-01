package org.example.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {


          List<String> words = List.of("one", "two", "three", "four", "five");


        List<Integer> collectInt = words.stream()
                .map(String::length)
                .collect(Collectors.toList());

        System.out.println(collectInt);



        List<String> collect = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(collect);



        List<String> a = words.stream()
                .filter(w -> !w.contains("a"))
                .collect(Collectors.toList());

        System.out.println(a);



    }
}

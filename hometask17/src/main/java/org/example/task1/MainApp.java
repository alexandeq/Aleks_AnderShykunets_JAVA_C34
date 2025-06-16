package org.example.task1;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class MainApp {
    public static void main(String[] args) {


        List.of(5, 11, 11, 15, 20, 25, 30, 35, 35, 40, 45, 50).stream()
                .filter(num -> num % 2 == 0)
                .distinct()
                .forEach(System.out::println);



        int sum = IntStream.of(5, 11, 11, 15, 20, 25, 30, 35, 35, 40, 45, 50)
                .sum();

        System.out.println(sum);



        System.out.println(IntStream.of(5, 11, 11, 15, 20, 25, 30, 35, 35, 40, 45, 50)
                .max());



        Optional<Integer> first = List.of(5, 11, 11, 15, 20, 25, 30, 35, 35, 40, 45, 50).stream()
                .filter(el -> el >= 10)
                .findFirst();
        System.out.println(first);



        boolean b = List.of(5, 11, 11, 15, 20, 25, 30, 35, 35, 40, 45, 50).stream()
                .allMatch(el -> el % 2 == 0);

        System.out.println(b);



    }

}

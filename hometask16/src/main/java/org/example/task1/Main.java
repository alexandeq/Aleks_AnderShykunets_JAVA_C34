package org.example.task1;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Predicate<Integer> adultAge = v -> v >= 18;
        System.out.println(adultAge.test(50));
        System.out.println(adultAge.test(14));


        Consumer<String> greetingMessage = str -> System.out.println("Welcome " + str);
        greetingMessage.accept("Marina");


        Supplier<Double> randomNumber = Math::random;
        System.out.println(randomNumber.get());


        Function<String,Integer> converter = String::length;
        System.out.println(converter.apply("Monday"));


    }
}
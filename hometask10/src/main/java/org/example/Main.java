package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String city = "Los Angeles";
        System.out.println(city.length());
        System.out.println(city.substring(4, city.length()));

        String newCity = "New-York-City";
        String[] split = newCity.split("-");
        System.out.println(split.length);

        StringBuilder builder = new StringBuilder();
        builder.append("My");
        builder.append("name");
        builder.append("is");
        builder.append("Den");
        builder.reverse();
        System.out.println(builder);

        String capital = String.format("%s is the capital of %s", "London", "Great Britain");
        System.out.println(capital);


    }
}
package org.example.evenNumbers;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbersList = List.of(1, 13, 84, 25, 16, 42, 52, 7, 31);
        List<Integer> evenList = new ArrayList<>();


        for (Integer evenNumbers : numbersList) {
            if (evenNumbers % 2 == 0)
                evenList.add(evenNumbers);

        }

        System.out.println(evenList);

    }
}




package org.example;

import org.example.domain.Worker;
import org.example.domain.Profession;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Worker> workers = List.of(
                new Worker(Profession.Boss, 5000),
                new Worker(Profession.Administrator, 3500),
                new Worker(Profession.Administrator, 3200),
                new Worker(Profession.Engineer, 3000),
                new Worker(Profession.Master, 2400),
                new Worker(Profession.Master, 2400),
                new Worker(Profession.Master, 2200));


        OptionalDouble average = workers.stream()
                .map(Worker::getSalary)
                .mapToInt(value -> value)
                .average();

        if (average.isPresent()) {
            double asDouble = average.getAsDouble();
            System.out.println("Average salary : " + asDouble);

        }


        Map<Profession, Long> workersCount = workers.stream()
                .collect(Collectors.groupingBy(Worker::getProfession, Collectors.counting()));
        System.out.println("Count of workers is: " + workersCount);


        Map<Profession, Integer> sumSalary = workers.stream()
                .collect(Collectors.groupingBy(Worker::getProfession, Collectors.summingInt(Worker::getSalary)));
        System.out.println("Sum of salary is: " + sumSalary);


    }
}
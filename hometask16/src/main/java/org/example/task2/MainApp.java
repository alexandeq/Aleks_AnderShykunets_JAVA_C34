package org.example.task2;

import java.util.TreeSet;

public class MainApp {

    public static void main(String[] args) {


        Worker worker1 = new Worker(5000);
        Worker worker2 = new Worker(1000);
        Worker worker3 = new Worker(2000);

        TreeSet<Worker> workers = new TreeSet<>((w1,w2) -> w1.getSalary() - w2.getSalary());

        workers.add(worker1);
        workers.add(worker2);
        workers.add(worker3);

        System.out.println(workers);


    }
}

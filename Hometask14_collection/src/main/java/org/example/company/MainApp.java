package org.example.company;

import org.example.company.domain.Order;

import java.util.HashSet;
import java.util.Set;

public class MainApp {
    public static void main(String[] args) {


        Order order1 = new Order("1A", "pizza", "cooking");
        Order order2 = new Order("2B", "soup", "ready");
        Order order3 = new Order("3C", "sushi", "deliver");
        Order order4 = new Order("4D", "hamburger", "cooking");
        Order order5 = new Order("5E", "cheeseburger", "ready");
        Order order6 = new Order("6F", "soup", "cooking");
        Order order7 = new Order("6F", "soup", "cooking");


        Set<Order> set = new HashSet<>();
        set.add(order1);
        set.add(order2);
        set.add(order3);
        set.add(order4);
        set.add(order5);
        set.add(order6);
        set.add(order7);


        System.out.println(set);


    }
}
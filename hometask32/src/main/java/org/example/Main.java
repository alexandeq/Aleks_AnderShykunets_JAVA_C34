package org.example;

import org.example.entity.Address;
import org.example.entity.OrderEntity;
import org.example.entity.Type;
import org.example.service.OrderService;
import java.time.Instant;

public class Main {

    private static final OrderService service = new OrderService();

    public static void main(String[] args) {

        var address1 = new Address("center", "Rakovaskaya");
        var address2 = new Address("kaskad", "Skryganowa");
        var address3 = new Address("minsk-world", "Mira");

        var order1  = new OrderEntity("hot-dog", Type.MEAT, Instant.now(), address1, 20L, true);
        var order2  = new OrderEntity("salad", Type.VEGAN, Instant.now(), address2, 11L,true );
        var order3  = new OrderEntity("shrimps", Type.FISH, Instant.now(), address3, 15L, false);

        service.save(order1);
        service.save(order2);
        service.save(order3);

        service.getById(order1.getId());
        service.getById(order2.getId());
        service.getById(order3.getId());

    }
}
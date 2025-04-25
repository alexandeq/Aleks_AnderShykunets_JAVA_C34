package company.service;

import company.domain.Order;

public interface DeliveryService {

    default void deliveryOption() {
        System.out.println("Self Pickup point at: Qwerty Street");
    }

    void deliveryOrder(Order order);

}

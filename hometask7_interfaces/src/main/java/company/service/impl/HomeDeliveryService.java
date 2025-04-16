package company.service.impl;

import company.domain.Order;
import company.service.DeliveryService;
import company.service.OrderStatusService;

public class HomeDeliveryService implements DeliveryService {

    public void deliveryOrder(Order order) {
        if (order.getAdress() != null) {
            System.out.println("Order on the way on: " + order.getAdress() + " street");
        }

        if (order.getAdress() == null) {
            System.out.println("Error adress: please enter delivery adress");
        }


    }
}

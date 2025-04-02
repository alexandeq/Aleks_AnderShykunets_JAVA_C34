package company.service.impl;

import company.domain.Order;
import company.service.DeliveryService;

public class SelfPickupDeliveryServiceImpl implements DeliveryService {

    @Override
    public void deliveryOrder(Order order) {
        if (order.getAdress() == null) {
                this.deliveryOption();
        }

        if (order.getAdress() != null) {
                System.out.println("Selected SelfPickup option at: Qwerty Street");
        }


    }
}

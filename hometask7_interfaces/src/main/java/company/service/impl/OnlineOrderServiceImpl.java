package company.service.impl;

import company.domain.Order;
import company.service.OrderCreatedService;

public class OnlineOrderServiceImpl implements OrderCreatedService {

    @Override
    public boolean isCreated(Order order) {
        if (order == null) {
            return false;
        } else if (order.getDish() == null) {
            return false;
        } else {
            return order.getEmail() != null;
        }


    }
}
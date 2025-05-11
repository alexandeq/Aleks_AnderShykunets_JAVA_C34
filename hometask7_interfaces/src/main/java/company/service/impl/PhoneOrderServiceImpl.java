package company.service.impl;

import company.domain.Order;
import company.service.OrderCreatedService;

public class PhoneOrderServiceImpl implements OrderCreatedService {


    @Override
    public boolean isCreated(Order order) {
        if (order == null) {
            return false;
        } else if (order.getDish() == null) {
            return false;
        } else if (order.getEmail() == null) {
            return false;
        } else {
            return order.getPhoneNumber().length() >= 6;


        }
    }
}

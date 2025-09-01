package company.service.impl;

import company.domain.Order;
import company.service.OrderDataService;

public class OrderDatabaseDataServiceImpl implements OrderDataService {

    @Override
    public void saveOrder(Order order) {
        System.out.println("Order: " + order.getDish());

    }
}
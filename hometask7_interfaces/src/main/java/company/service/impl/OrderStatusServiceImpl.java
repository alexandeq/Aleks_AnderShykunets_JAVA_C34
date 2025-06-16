package company.service.impl;

import company.domain.Order;
import company.service.OrderStatusService;

import java.io.PrintStream;

public class OrderStatusServiceImpl implements OrderStatusService {

    @Override
    public void checkStatus(Order order, String message) {
        System.out.println("Order: " + order.getDish() + message);

    }
}

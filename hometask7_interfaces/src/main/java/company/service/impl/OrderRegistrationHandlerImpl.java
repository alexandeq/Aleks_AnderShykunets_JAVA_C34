package company.service.impl;

import company.domain.Order;
import company.service.*;

public class OrderRegistrationHandlerImpl implements OrderRegistrationHandler {

    private OrderCreatedService createdService;
    private OrderDataService dataService;
    private OrderStatusService statusService;
    private DeliveryService deliveryService;

    public OrderRegistrationHandlerImpl(OrderCreatedService createdService, OrderDataService dataService, OrderStatusService statusService, DeliveryService deliveryService) {
        this.createdService = createdService;
        this.deliveryService = deliveryService;
        this.statusService = statusService;
        this.dataService = dataService;
    }

    public void registrOrder(Order order) {
        boolean isCreated = this.createdService.isCreated(order);
        if (isCreated) {
            this.dataService.saveOrder(order);
        }

        this.statusService.checkStatus(order, isCreated ? " in progress ..." : " - error order created");
        if (isCreated) {
            this.deliveryService.deliveryOrder(order);
        }

    }
}

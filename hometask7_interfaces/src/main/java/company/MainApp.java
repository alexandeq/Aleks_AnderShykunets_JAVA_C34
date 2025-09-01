package company;

import company.domain.Order;
import company.service.OrderRegistrationHandler;
import company.service.impl.*;

public class MainApp {
    public static void main(String[] args) {


        Order order = new Order("Hot dog", "abc", "12312254", "xyz");

        OrderRegistrationHandler handler =
                new OrderRegistrationHandlerImpl(new OnlineOrderServiceImpl(),
                        new OrderDatabaseDataServiceImpl(),
                        new OrderStatusServiceImpl(),
                        new HomeDeliveryService());


        handler.registrOrder(order);


    }
}
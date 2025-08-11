package company.service;

import company.domain.Order;

public interface OrderStatusService {

        void checkStatus(Order order,String string);

    }

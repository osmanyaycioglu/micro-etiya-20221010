package org.training.microservice.msorder.services;

import org.springframework.stereotype.Service;
import org.training.microservice.msorder.models.Order;

@Service
public class OrderProcessService {

    public String placeOrder(Order order) {
        return "OK";
    }

}

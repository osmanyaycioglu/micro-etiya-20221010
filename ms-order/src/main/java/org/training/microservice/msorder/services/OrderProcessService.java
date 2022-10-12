package org.training.microservice.msorder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.microservice.msorder.integrations.accounting.AccountingIntegration;
import org.training.microservice.msorder.models.Order;

@Service
public class OrderProcessService {

    @Autowired
    private AccountingIntegration accountingIntegration;

    public String placeOrder(Order order) {
        return accountingIntegration.pay(102L,100D);
    }

    public String placeOrder2(Order order) {
        return accountingIntegration.pay2(102L,100D);
    }

    public String placeOrder3(Order order) {
        return accountingIntegration.pay3(102L,100D);
    }

}

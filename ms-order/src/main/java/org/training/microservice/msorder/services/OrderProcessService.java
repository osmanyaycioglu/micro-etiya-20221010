package org.training.microservice.msorder.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.microservice.msorder.integrations.accounting.AccountingIntegration;
import org.training.microservice.msorder.models.NotifyMessage;
import org.training.microservice.msorder.models.Order;

@Service
public class OrderProcessService {

    @Autowired
    private AccountingIntegration accountingIntegration;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public String placeOrder(Order order) {
        return accountingIntegration.pay(102L,100D);
    }

    public String placeOrder2(Order order) {
        return accountingIntegration.pay2(102L,100D);
    }

    public String placeOrder3(Order order) {
        String s = accountingIntegration.pay3(102L,
                                              100D);
        NotifyMessage notifyMessage = new NotifyMessage();
        notifyMessage.setMsg("Siparişiniz alındı");
        notifyMessage.setDest(order.getCustomerNumber());
        rabbitTemplate.convertAndSend("message-exchange","sms-message",notifyMessage);
        return s;
    }

}

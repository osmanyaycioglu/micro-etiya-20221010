package org.training.microservice.msnotification.listeners;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {

    @Value("${server.port}")
    private int port;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "sms-queue", autoDelete = "false", durable = "true"),
            exchange = @Exchange(value = "message-exchange", autoDelete = "false", durable = "true", type = ExchangeTypes.DIRECT),
            key = "sms-message"
    ))
    // @SendTo("exchange/routekey")
    public void handle(NotifyMessage str) {
        System.out.println(port + " Received SMS : " + str);
    }

}

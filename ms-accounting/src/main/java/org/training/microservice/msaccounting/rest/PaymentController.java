package org.training.microservice.msaccounting.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import org.training.microservice.accounting.models.PaymentRequest;
import org.training.microservice.accounting.models.PaymentResult;
import org.training.microservice.accounting.rest.IPaymentController;

@RestController
public class PaymentController implements IPaymentController {

    @Value("${server.port}")
    private int port;

    private int counter;

    @Override
    public PaymentResult pay(@RequestBody PaymentRequest paymentRequest) {
        counter++;
        if (counter % 2 == 0){
            throw new IllegalArgumentException("Test için exp : " + counter);
        }
        return new PaymentResult().setResult(1)
                                  .setCustomerId(paymentRequest.getCustomerId())
                                  .setDesc("ödeme başarıyla yapıldı " + port);
    }
}

package org.training.microservice.accounting.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.training.microservice.accounting.models.PaymentRequest;
import org.training.microservice.accounting.models.PaymentResult;

public interface IPaymentController {

    @PostMapping("/api/v1/accounting/payment/pay")
    public PaymentResult pay(@RequestBody PaymentRequest paymentRequest);

}

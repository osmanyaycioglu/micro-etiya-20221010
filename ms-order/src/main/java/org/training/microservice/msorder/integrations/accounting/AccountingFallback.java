package org.training.microservice.msorder.integrations.accounting;

import org.training.microservice.accounting.models.PaymentRequest;
import org.training.microservice.accounting.models.PaymentResult;

public class AccountingFallback implements IAccountingFeignClient{

    @Override
    public PaymentResult pay(PaymentRequest paymentRequest) {
        return new PaymentResult();
    }

}

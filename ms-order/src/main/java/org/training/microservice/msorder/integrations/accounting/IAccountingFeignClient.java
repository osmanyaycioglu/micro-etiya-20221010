package org.training.microservice.msorder.integrations.accounting;

import org.springframework.cloud.openfeign.FeignClient;
import org.training.microservice.accounting.rest.IPaymentController;

// @FeignClient(value = "ACCOUNTING", fallback = AccountingFallback.class)
@FeignClient(value = "ACCOUNTINGAPI")
public interface IAccountingFeignClient extends IPaymentController {
}

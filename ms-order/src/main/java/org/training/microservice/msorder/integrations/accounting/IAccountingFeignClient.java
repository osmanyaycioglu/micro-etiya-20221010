package org.training.microservice.msorder.integrations.accounting;

import org.springframework.cloud.openfeign.FeignClient;
import org.training.microservice.accounting.rest.IPaymentController;

@FeignClient(value = "ACCOUNTING")
public interface IAccountingFeignClient extends IPaymentController {


}

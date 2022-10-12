package org.training.microservice.msorder.integrations.accounting;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.training.microservice.accounting.models.PaymentRequest;
import org.training.microservice.accounting.models.PaymentResult;

import java.util.List;

@Service
public class AccountingIntegration {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private IAccountingFeignClient accountingFeignClient;

    // @Retry(name = "accountingRetry")
    public String pay3(Long customerId,
                       double price) {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setCustomerId(customerId);
        paymentRequest.setAmount(price);
        PaymentResult paymentResult = accountingFeignClient.pay(paymentRequest);
        if (paymentResult == null) {
            return "ödeme yapılamadı ";
        }
        return "payment result : " + paymentResult.getResult() + " - " + paymentResult.getDesc();

    }


    public String pay(Long customerId,
                      double price) {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setCustomerId(customerId);
        paymentRequest.setAmount(price);
        PaymentResult paymentResult = restTemplate.postForObject("http://ACCOUNTING/api/v1/accounting/payment/pay",
                                                                 paymentRequest,
                                                                 PaymentResult.class);
        if (paymentResult == null) {
            return "ödeme yapılamadı ";
        }
        return "payment result : " + paymentResult.getResult() + " - " + paymentResult.getDesc();
    }

    private int counter = 0;

    public String pay2(Long customerId,
                       double price) {
        counter++;
        Application accounting = eurekaClient.getApplication("ACCOUNTING");
        List<InstanceInfo> instances = accounting.getInstances();
        if (!instances.isEmpty()) {
            int index = counter % instances.size();
            InstanceInfo instanceInfo = instances.get(index);
            PaymentRequest paymentRequest = new PaymentRequest();
            paymentRequest.setCustomerId(customerId);
            paymentRequest.setAmount(price);
            RestTemplate template = new RestTemplate();
            PaymentResult paymentResult = template.postForObject("http://" + instanceInfo.getIPAddr()
                                                                         + ":"
                                                                         + instanceInfo.getPort()
                                                                         + "/api/v1/accounting/payment/pay",
                                                                 paymentRequest,
                                                                 PaymentResult.class);
            if (paymentResult == null) {
                return "ödeme yapılamadı ";
            }
            return "payment result : " + paymentResult.getResult() + " - " + paymentResult.getDesc();

        }
        return "payment result : MS problemi";

    }

}

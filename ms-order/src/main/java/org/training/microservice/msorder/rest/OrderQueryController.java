package org.training.microservice.msorder.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.training.microservice.msorder.rest.models.OrderRestObj;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order/query")
@RefreshScope
public class OrderQueryController {

    @Value("${app.test.abc}")
    private String testStr;

    @GetMapping("/test")
    public String testRefresh(){
        return testStr;
    }

    @GetMapping("/info")
    public OrderRestObj orderInfo(@RequestParam("oid") String orderId) {
        return null;
    }

    @GetMapping("/get/all/active")
    public List<OrderRestObj> getAllActive() {
        return null;
    }

    @GetMapping("/get/all/on/delivery")
    public List<OrderRestObj> getOndelivery() {
        return null;
    }

    @GetMapping("/get/all/completed")
    public List<OrderRestObj> getCompletedOrders() {
        return null;
    }

}

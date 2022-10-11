package org.training.microservice.msorder.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.training.microservice.msorder.rest.models.OrderRestObj;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order/query")
public class OrderQueryController {

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

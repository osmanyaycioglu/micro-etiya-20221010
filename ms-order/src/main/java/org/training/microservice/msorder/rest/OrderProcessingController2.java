package org.training.microservice.msorder.rest;

import org.springframework.web.bind.annotation.*;
import org.training.microservice.msorder.rest.models.OrderRestObj;

@RestController
@RequestMapping("/api/v1/order/process2")
public class OrderProcessingController2 {

    @PutMapping
    public String placeOrder(@RequestBody OrderRestObj order) {
        return null;
    }

}

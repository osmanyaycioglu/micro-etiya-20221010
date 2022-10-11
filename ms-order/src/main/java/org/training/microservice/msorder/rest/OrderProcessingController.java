package org.training.microservice.msorder.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.training.microservice.msorder.rest.models.OrderRestObj;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/api/v1/order/process")
@Valid
public class OrderProcessingController {

    @PostMapping("/place")
    @Operation(summary = "use for place order", description = "long description for order")
    public String placeOrder(@Valid @RequestBody OrderRestObj order) {
        if (order.getCustomerName() == null) {
            throw new IllegalArgumentException("name boş olamaz");
        }
        return "Order received : " + order;
    }

    @GetMapping("/cancel/{abc}")
    public String cancel(@Parameter(description = "order Id input") @PathVariable("abc") String orderId) {
        return "Canceled";
    }

    @GetMapping("/pause")
    public String pause(@NotEmpty @RequestParam("oid") String orderId) {
        return "Canceled";
    }

}

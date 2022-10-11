package org.training.microservice.msorder.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.training.microservice.common.error.RestErrorObj;
import org.training.microservice.msorder.mappings.IOrderMappings;
import org.training.microservice.msorder.mappings.IOrderMappingsImpl;
import org.training.microservice.msorder.rest.models.OrderRestObj;
import org.training.microservice.msorder.services.OrderProcessService;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/order/process")
@Valid
public class OrderProcessingController {

    @Autowired
    private OrderProcessService orderProcessService;

    @PostMapping("/place")
    @Operation(summary = "use for place order", description = "long description for order")
    public String placeOrder(@Valid @RequestBody OrderRestObj order) {
        if (order.getCustomerName() == null) {
            throw new IllegalArgumentException("name boş olamaz");
        }
        return orderProcessService.placeOrder(IOrderMappings.MAPPER.toOrder(order));
    }

    @GetMapping("/cancel/{abc}")
    public String cancel(@Parameter(description = "order Id input") @PathVariable("abc") String orderId) {
        return "Canceled";
    }

    @GetMapping("/pause")
    public String pause(@NotEmpty @RequestParam("oid") String orderId) {
        return "Canceled";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestErrorObj handle(IllegalArgumentException exp) {
        return RestErrorObj.createRestErrorObj()
                           .setMicroservice("xyz order")
                           .setDesc(exp.getMessage())
                           .setCode(2020);
    }

}

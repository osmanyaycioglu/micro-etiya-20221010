package org.training.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.training.microservice.common.error.RestErrorObj;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorAdvice {

    @Value("${app.microservice.name}")
    private String msName;

    public RestErrorObj createBaseErrorObj() {
        return RestErrorObj.createRestErrorObj()
                           .setMicroservice(msName);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestErrorObj handle(IllegalArgumentException exp) {
        return createBaseErrorObj()
                .setDesc(exp.getMessage())
                .setCode(2020);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestErrorObj handle(MethodArgumentNotValidException exp) {
        return createBaseErrorObj()
                .setDesc("Validasyon problemi")
                .setCode(2020)
                .addSubErrors(exp.getAllErrors()
                                 .stream()
                                 .map(se -> createBaseErrorObj()
                                         .setDesc(se.toString())
                                         .setCode(2021))
                                 .collect(Collectors.toList())
                );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestErrorObj handle(ConstraintViolationException exp) {
        return createBaseErrorObj()
                .setDesc("Validasyon problemi")
                .setCode(2020)
                .addSubErrors(exp.getConstraintViolations()
                                 .stream()
                                 .map(se -> RestErrorObj.createRestErrorObj()
                                                        .setMicroservice("order")
                                                        .setDesc(se.toString())
                                                        .setCode(2021))
                                 .collect(Collectors.toList())
                );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestErrorObj> handle(Exception exp) {
        if (exp instanceof NullPointerException) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                                 .header("test-null",
                                         "test")
                                 .body(createBaseErrorObj()
                                               .setDesc(exp.getMessage())
                                               .setCode(5001));

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .header("test-hd",
                                     "test")
                             .body(createBaseErrorObj()
                                           .setDesc(exp.getMessage())
                                           .setCode(5000));
    }

    @ExceptionHandler(MSRestClientException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public RestErrorObj handle(MSRestClientException exp) {
        return createBaseErrorObj()
                .setDesc("microservisi çağırırken problem oluştu")
                .setCode(3048)
                .addSubError(exp.getRestErrorObj());
    }

}

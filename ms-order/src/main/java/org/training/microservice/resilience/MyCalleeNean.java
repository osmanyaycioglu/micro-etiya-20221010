package org.training.microservice.resilience;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Component;

@Component
public class MyCalleeNean {
    private int counter = 0;

    @Retry(name = "accountingRetry")
    //@CircuitBreaker(name = "accountingCB",fallbackMethod = "helloFallback")
    @CircuitBreaker(name = "accountingCB")
    public String hello(String name) {
        counter++;
        if (counter < 15) {
            if (counter % 3 == 0) {
                throw new IllegalCallerException("test - " + counter);
            }
        }
        return "hello : " + name;
    }

    // @Retry(name = "accountingRetry", fallbackMethod = "helloFallback")
    // @CircuitBreaker(name = "accountingCB")
    public String hello2(String name) {
        counter++;
        if (counter < 20) {
            if (counter % 3 == 0) {
                throw new IllegalCallerException("test - " + counter);
            }
        } else {
            throw new IllegalArgumentException("test " + counter);
        }

        return "hello : " + name;
    }

    public String helloFallback(String name,
                                Throwable throwable) {
        return "hello fallback";
    }
}
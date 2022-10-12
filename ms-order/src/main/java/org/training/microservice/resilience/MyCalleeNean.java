package org.training.microservice.resilience;

import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Component;

@Component
public class MyCalleeNean {
    private int counter = 0;

    @Retry(name = "accountingRetry")
    public String hello(String name) {
        counter++;
        if (counter < 20) {
            if (counter % 3 == 0) {
                throw new IllegalCallerException("test - " + counter );
            }
        } else {
            throw new IllegalArgumentException("test " + counter);
        }

        return "hello : " + name;
    }

}

package org.training.microservice.resilience;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCallerBEan implements CommandLineRunner {
    @Autowired
    private MyCalleeNean myCalleeNean;

    @Autowired
    private RetryRegistry retryRegistry;

    @Override
    public void run(String... args) throws Exception {
        Retry retry = retryRegistry.retry("accountingRetry");
        Retry.Metrics metrics = retry.getMetrics();

        for (int i = 0; i < 40; i++) {
            try {
                System.out.println("Index : " + i + " " + myCalleeNean.hello("osman") + " Thread : " + Thread.currentThread().getName());
            } catch (IllegalCallerException exp) {
                System.out.println("Caller Exp : " + exp.getMessage() + " Thread : " + Thread.currentThread().getName());
            } catch (Exception e) {
                System.out.println("Exp : " + e.getMessage() + " Thread : " + Thread.currentThread().getName());
            }
            System.out.println("getNumberOfSuccessfulCallsWithRetryAttempt : " + metrics.getNumberOfSuccessfulCallsWithRetryAttempt() +
                                       " getNumberOfSuccessfulCallsWithoutRetryAttempt : " + metrics.getNumberOfSuccessfulCallsWithoutRetryAttempt() +
                                       " getNumberOfFailedCallsWithoutRetryAttempt : " + metrics.getNumberOfFailedCallsWithoutRetryAttempt() +
                                       " getNumberOfFailedCallsWithRetryAttempt : " + metrics.getNumberOfFailedCallsWithRetryAttempt());

        }
    }

}

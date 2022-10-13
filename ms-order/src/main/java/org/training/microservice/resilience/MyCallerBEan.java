package org.training.microservice.resilience;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Component
public class MyCallerBEan implements CommandLineRunner {
    @Autowired
    private MyCalleeNean myCalleeNean;

    @Autowired
    private RetryRegistry retryRegistry;

    @Autowired
    private CircuitBreakerRegistry circuitBreakerRegistry;

    public void run(String... args) throws Exception {
//        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
//                                                                        .slidingWindowSize(20)
//                                                                        .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
//                                                                        .waitDurationInOpenState(Duration.ofMillis(10000)).build();
//        CircuitBreaker xyz = circuitBreakerRegistry.circuitBreaker("xyz",
//                                                                   circuitBreakerConfig);
        CircuitBreaker accountingCB = circuitBreakerRegistry.circuitBreaker("accountingCB");
        CircuitBreaker.Metrics metrics = accountingCB.getMetrics();
        accountingCB.getEventPublisher()
                    .onStateTransition(s -> System.out.println("state değişti : " + s.getStateTransition()));
        Retry retry = retryRegistry.retry("accountingRetry");
        Retry.Metrics rmetrics = retry.getMetrics();
        Retry.EventPublisher eventPublisher = retry.getEventPublisher();

        for (int i = 0; i < 40; i++) {
            try {
                System.out.println("Index : " + i + " " + myCalleeNean.hello("osman"));
            } catch (IllegalCallerException exp) {
                System.out.println("Caller Exp : " + exp.getMessage() + " Thread : " + Thread.currentThread()
                                                                                             .getName());
            } catch (Exception e) {
                System.out.println("Exp : " + e.getMessage() + " Thread : " + Thread.currentThread()
                                                                                    .getName());
            }
            Thread.sleep(1000);
            System.out.println("state : " + accountingCB.getState()
                                       + " s:" + metrics.getNumberOfSuccessfulCalls()
                                       + " f:" + metrics.getNumberOfFailedCalls()
                                       + " n:" + metrics.getNumberOfNotPermittedCalls());

            System.out.println("swr:" + rmetrics.getNumberOfSuccessfulCallsWithRetryAttempt() +
                                       " swor:" + rmetrics.getNumberOfSuccessfulCallsWithoutRetryAttempt() +
                                       " fwor:" + rmetrics.getNumberOfFailedCallsWithoutRetryAttempt() +
                                       " fwr:" + rmetrics.getNumberOfFailedCallsWithRetryAttempt());

        }

    }

    public void run2(String... args) throws Exception {
        Retry retry = retryRegistry.retry("accountingRetry");
        Retry.Metrics metrics = retry.getMetrics();
        Retry.EventPublisher eventPublisher = retry.getEventPublisher();
        eventPublisher.onError(r -> System.out.println(r.getEventType() + " " + r.getName() + " retry count : " + r.getNumberOfRetryAttempts()));
        eventPublisher.onRetry(r -> System.out.println(r.getEventType() + " " + r.getName() + " retry count : " + r.getNumberOfRetryAttempts()));
        for (int i = 0; i < 40; i++) {
            try {
                System.out.println("Index : " + i + " " + myCalleeNean.hello("osman") + " Thread : " + Thread.currentThread()
                                                                                                             .getName());
            } catch (IllegalCallerException exp) {
                System.out.println("Caller Exp : " + exp.getMessage() + " Thread : " + Thread.currentThread()
                                                                                             .getName());
            } catch (Exception e) {
                System.out.println("Exp : " + e.getMessage() + " Thread : " + Thread.currentThread()
                                                                                    .getName());
            }
            System.out.println("getNumberOfSuccessfulCallsWithRetryAttempt : " + metrics.getNumberOfSuccessfulCallsWithRetryAttempt() +
                                       " getNumberOfSuccessfulCallsWithoutRetryAttempt : " + metrics.getNumberOfSuccessfulCallsWithoutRetryAttempt() +
                                       " getNumberOfFailedCallsWithoutRetryAttempt : " + metrics.getNumberOfFailedCallsWithoutRetryAttempt() +
                                       " getNumberOfFailedCallsWithRetryAttempt : " + metrics.getNumberOfFailedCallsWithRetryAttempt());

        }
    }

}

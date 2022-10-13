package org.training.microservice.apigwaccounting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApigwAccountingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApigwAccountingApplication.class,
                              args);
    }

}

package org.training.microservice.msaccounting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;
import org.training.common.ErrorConfig;

@SpringBootApplication
@EnableEurekaClient
@Import(ErrorConfig.class)
public class MsAccountingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsAccountingApplication.class,
                              args);
    }

}

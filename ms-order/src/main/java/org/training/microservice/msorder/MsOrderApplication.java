package org.training.microservice.msorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.training.common.ErrorConfig;

@SpringBootApplication
//@SpringBootApplication(scanBasePackages = {"org.training.microservice.msorder",
//                                           "org.training.common"
//})
@EnableEurekaClient
@Import({ErrorConfig.class})
public class MsOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsOrderApplication.class,
                              args);
    }

}

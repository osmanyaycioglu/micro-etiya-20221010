package org.training.microservice.msorder;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;
import org.training.common.ClientErrorConfig;
import org.training.common.ErrorConfig;

@SpringBootApplication(scanBasePackages = {"org.training.microservice.msorder","org.training.microservice.resilience"})
//@SpringBootApplication(scanBasePackages = {"org.training.microservice.msorder",
//                                           "org.training.common"
//})
@EnableEurekaClient
@EnableFeignClients
@Import({ErrorConfig.class,
         ClientErrorConfig.class})
public class MsOrderApplication {

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(MsOrderApplication.class,
                              args);
    }

}

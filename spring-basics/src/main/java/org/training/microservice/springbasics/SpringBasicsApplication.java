package org.training.microservice.springbasics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.training.microservice.springbasics.basic.Greetings;

@SpringBootApplication
public class SpringBasicsApplication {

    @Autowired
    @Qualifier("myGreetings")
    private Greetings grt;

    public static void main(String[] args) {
        SpringApplication.run(SpringBasicsApplication.class,
                              args);
    }

}

package org.training.microservice.springbasics.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
//@Primary
public class Greetings {
    // Field Injection
    @Autowired
    private HelloEng helloEng;

    @Autowired
    private Environment environment;

    @Value("${server.port}")
    private Integer serverPort;

    @PostConstruct
    public void abc(){
        // init
        environment.getProperty("server.port");
    }

    public String greet(String name) {
        return helloEng.hello(name);
    }
}

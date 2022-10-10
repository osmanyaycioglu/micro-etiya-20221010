package org.training.microservice.springbasics.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class GreetingsCons {

    private HelloEng helloEng;

    // Constructor injection
    @Autowired
    public GreetingsCons(HelloEng helloEng,
                         @Value("${server.port}") Integer serverPort,
                         Environment environment) {
        // init
        this.helloEng = helloEng;
        String property = environment.getProperty("server.port");
    }

    public String greet(String name) {
        return helloEng.hello(name);
    }
}

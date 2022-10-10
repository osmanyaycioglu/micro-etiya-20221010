package org.training.microservice.springbasics.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreetingsMethod {

    private HelloEng helloEng;

    public String greet(String name) {
        return helloEng.hello(name);
    }
    // method injection
    @Autowired
    public void setHelloEng(HelloEng helloEng) {
        this.helloEng = helloEng;
    }
}

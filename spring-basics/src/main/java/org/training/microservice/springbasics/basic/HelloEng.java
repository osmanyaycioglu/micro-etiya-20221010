package org.training.microservice.springbasics.basic;

import org.springframework.stereotype.Component;

@Component
public class HelloEng {

    public String hello(String name){
        return "Hello " + name;
     }

}

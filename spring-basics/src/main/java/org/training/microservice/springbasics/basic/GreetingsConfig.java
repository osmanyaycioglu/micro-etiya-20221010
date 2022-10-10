package org.training.microservice.springbasics.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Controller
//@Service
//@Repository
@Configuration
public class GreetingsConfig {

    @Bean("myGreetings")
    //@Scope("prototype")
    public Greetings greetings(){
        return new Greetings();
    }

    @Bean("myGreetings2")
    public Greetings greetings2(){
        return new Greetings();
    }

}

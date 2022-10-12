package org.training.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientErrorConfig {

    @Bean
    public MSFeignErrorDecoder feignErrorDecoder(){
        return new MSFeignErrorDecoder();
    }

}

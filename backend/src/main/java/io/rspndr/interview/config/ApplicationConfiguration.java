package io.rspndr.interview.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mapping.callback.EntityCallbacks;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public EntityCallbacks entityCallbacks() {
        return EntityCallbacks.create();
    }
}

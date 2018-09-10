package com.metacube.training.singleton_scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Scope("singleton")
    public Person person() {
        
        Person person = new Person();
        person.setName("Jai");        
        return person;
    }

}

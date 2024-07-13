package com.luv2code.springboot.demo.springcoredemo.config;

import com.luv2code.springboot.demo.springcoredemo.common.SwimCoach;
import com.luv2code.springboot.demo.springcoredemo.common.coach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean("aquatic")
    public coach swimCoach(){
        return new SwimCoach();
    }
}

package com.luv2code.springboot.demo.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements coach{
    public BaseballCoach() {
        System.out.println("In constructor: "+getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in batting practice";
    }
}

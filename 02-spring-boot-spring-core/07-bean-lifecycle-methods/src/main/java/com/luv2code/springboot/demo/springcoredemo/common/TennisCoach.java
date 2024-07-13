package com.luv2code.springboot.demo.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements coach{
    public TennisCoach() {
        System.out.println("In constructor: "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice back hand rally for 15 minutes";
    }
}

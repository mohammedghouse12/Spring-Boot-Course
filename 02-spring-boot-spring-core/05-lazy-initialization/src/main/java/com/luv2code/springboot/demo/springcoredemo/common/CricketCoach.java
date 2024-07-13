package com.luv2code.springboot.demo.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements coach {
    public CricketCoach() {
        System.out.println("In constructor: "+getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}

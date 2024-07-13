package com.luv2code.springboot.demo.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements coach{
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}

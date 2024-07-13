package com.luv2code.springboot.demo.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements coach{
    public TrackCoach() {
        System.out.println("In constructor: "+getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5K";
    }
}

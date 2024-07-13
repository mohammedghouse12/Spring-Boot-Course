package com.luv2code.springboot.demo.springcoredemo.common;

public class SwimCoach implements coach{
    public SwimCoach() {
        System.out.println("In constructor: "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000m as a warmup";
    }
}

package com.luv2code.springboot.demo.springcoredemo.rest;

import com.luv2code.springboot.demo.springcoredemo.common.coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.Lazy;

@RestController

public class DemoController {
    private coach myCoach;

    @Autowired
    public DemoController(@Qualifier("cricketCoach") coach myCoach) {
        System.out.println("In constructor: "+getClass().getName());
        this.myCoach = myCoach;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}

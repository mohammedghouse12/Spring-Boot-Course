package com.luv2code.springboot.demo.springcoredemo.rest;

import com.luv2code.springboot.demo.springcoredemo.common.coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DemoController {
    private coach myCoach;

    @Autowired
    public DemoController(@Qualifier("aquatic") coach myCoach) {
        System.out.println("In constructor: "+ getClass().getSimpleName());
        this.myCoach = myCoach;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}

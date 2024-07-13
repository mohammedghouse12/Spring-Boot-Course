package com.luv2code.springboot.demo.springcoredemo.rest;

import com.luv2code.springboot.demo.springcoredemo.common.coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private coach myCoach;

    @Autowired
    public void setMyCoach(coach myCoach) {
        this.myCoach = myCoach;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}

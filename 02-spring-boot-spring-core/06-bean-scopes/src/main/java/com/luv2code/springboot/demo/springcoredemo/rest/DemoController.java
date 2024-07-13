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
    private coach myAnotherCoach;

    @Autowired
    public DemoController(@Qualifier("cricketCoach") coach myCoach, @Qualifier("cricketCoach") coach myAnotherCoach) {
        System.out.println("In constructor: "+ getClass().getSimpleName());
        this.myCoach = myCoach;
        this.myAnotherCoach = myAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: myCoach=myAnotherCoach, "+(myCoach==myAnotherCoach);
    }
}

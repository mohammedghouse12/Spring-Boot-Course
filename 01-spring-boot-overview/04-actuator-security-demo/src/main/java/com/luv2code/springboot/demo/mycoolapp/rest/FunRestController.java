package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String sayHello(){
        return "Hello world!";
    }

    //exposing a new endpoint for "workout"

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5K";
    }

    //exposing a new endpoint for "fortune"

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day";
    }

    @GetMapping("/teaminfo")
    public String getTeaminfo(){
        return coachName+": "+teamName;
    }
}

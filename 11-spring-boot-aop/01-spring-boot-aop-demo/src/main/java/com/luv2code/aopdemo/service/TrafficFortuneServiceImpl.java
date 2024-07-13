package com.luv2code.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneServiceImpl implements TrafficFortuneService{

    @Override
    public String getFortune() throws Throwable{
        try{
            TimeUnit.SECONDS.sleep(5);
        }
        catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        if(1==0){
             throw new Exception("Exception occured");
        }

        return "Expect heavy traffic this morning";
    }
}

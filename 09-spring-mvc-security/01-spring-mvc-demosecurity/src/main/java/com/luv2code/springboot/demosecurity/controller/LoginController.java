package com.luv2code.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){
        return "fancy-login";
    }

    @RequestMapping("/leaders")
    public String showLeaders(){
        return "leaders";
    }

    @RequestMapping("/systems")
    public String showAdmins(){
        return "systems";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "access-denied";
    }
}

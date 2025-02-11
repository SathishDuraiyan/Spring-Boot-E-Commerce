package com.example.simplewebApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "Login Page...";
    }
    @RequestMapping("/about")
    public String about(){
        return "I'm Sathish,Software Engineer";
    }
}

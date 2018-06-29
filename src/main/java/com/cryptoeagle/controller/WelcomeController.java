package com.cryptoeagle.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WelcomeController {

    @RequestMapping("/")
   public String welcome(){
       return  "welcome";
   }

    @RequestMapping("/register")
    public String register(){
        return  "register";
    }
}

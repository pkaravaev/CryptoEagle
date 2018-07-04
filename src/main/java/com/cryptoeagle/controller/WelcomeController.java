package com.cryptoeagle.controller;


import com.cryptoeagle.entity.User;
import com.cryptoeagle.repository.UserRepository;
import com.cryptoeagle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class WelcomeController {

    @Autowired
    UserService service;

    @RequestMapping("/")
    public String welcome(){
        return  "welcome";
    }


    @RequestMapping("/users")
    public String test(Model model){

        List<User> users = service.findAll();
        model.addAttribute(users);
        return  "users";
    }


    @RequestMapping("/register")
    public String register(){
        return  "register";
    }
}

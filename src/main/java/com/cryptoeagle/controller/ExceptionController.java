package com.cryptoeagle.controller;


import com.cryptoeagle.exception.UserNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFound(Model model){
       model.addAttribute("error", "User not found!!!");
        return  "error-page";

    }
}

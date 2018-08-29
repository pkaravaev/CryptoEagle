package com.cryptoeagle.controller;


import com.cryptoeagle.exception.RssNewsNotFoundException;
import com.cryptoeagle.exception.UserNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFound(Model model){
       model.addAttribute("error", "User not found!!!");
        return  "error-page";
    }

    @ExceptionHandler(RssNewsNotFoundException.class)
    public String newsNotFound(Model model){
        model.addAttribute("error", "News not found!!!");
        return  "error-page";
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public String itemsNotFound(Model model){
        model.addAttribute("error", "News not found!!!");
        return  "error-page";
    }
}
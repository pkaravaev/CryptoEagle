package com.cryptoeagle.controller;


import com.cryptoeagle.exception.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.jws.WebParam;
import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(Exception.class)
    public String userNotFound(Exception e, Model model) {
        model.addAttribute("error", e.getMessage());
        return "error-page";
    }

}

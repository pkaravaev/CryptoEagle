package com.cryptoeagle.controller;


import com.cryptoeagle.service.abst.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @RequestMapping("/blog/remove/{id}")
    public String remove(@PathVariable int id) {
    blogService.delete(id,100);
        return "redirect:/blogs";
    }
}

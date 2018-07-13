package com.cryptoeagle.controller;


import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.service.BlogService;
import com.cryptoeagle.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@SessionAttributes("user")
public class MainController {

    @Autowired
    ItemService itemService;

    @Autowired
    BlogService blogService;

    @RequestMapping("/")
    public String welcome( Model model) {
        List<Item> items = itemService.findall();
        model.addAttribute("itemslist",items);
        return "welcome";
    }

    @RequestMapping("/blogs")
    public String blogs( Model model) {

        return "blogs";
    }

}

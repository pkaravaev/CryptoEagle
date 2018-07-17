package com.cryptoeagle.controller;


import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.coins.Ico;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.service.abst.*;
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

    @Autowired
    UserService userService;

    @Autowired
    IcoService icoService;

    @ModelAttribute("blog")
    public Blog contructBlog() {
        return new Blog();
    }


    @RequestMapping("/")
    public String welcome(Model model) {
        List<Item> items = itemService.findall();

        List<Ico> upIco = icoService.getUpcomingIco();
        List<Ico> finIco = icoService.getFinishedIco();
        List<Ico> actIco = icoService.getActiveIco();

        model.addAttribute("items", items);

        model.addAttribute("upIco", upIco);
        model.addAttribute("finIco", finIco);
        model.addAttribute("actIco", actIco);
        return "welcome";
    }

    @RequestMapping("/blogs")
    public String blogs(Model model) {

        List<Blog> blogs = blogService.findall(100);
        List<Item> items = itemService.findall();

        AppUser user = userService.get(100);
        model.addAttribute("user", user);
        return "blogs";
    }

    @RequestMapping("/test")
    public String test(Model model) {
        List<Item> items = itemService.findall();

        List<Ico> upIco = icoService.getUpcomingIco();
        List<Ico> finIco = icoService.getFinishedIco();
        List<Ico> actIco = icoService.getActiveIco();

        model.addAttribute("items", items);

        model.addAttribute("upIco", upIco);
        model.addAttribute("finIco", finIco);
        model.addAttribute("actIco", actIco);
        return "test";
    }

}

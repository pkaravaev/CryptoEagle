package com.cryptoeagle.controller;


import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.service.abst.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


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

    @Autowired
    RssService rssService;

    @ModelAttribute("blog")
    public Blog contructBlog() {
        return new Blog();
    }


    @RequestMapping("/")
    public String welcome(Model model) {
        List<Item> items = itemService.findall();

        List<Ico> upIco = icoService.getUpcomingIco().stream().limit(20).collect(Collectors.toList());
        List<Ico> finIco = icoService.getFinishedIco().stream().limit(20).collect(Collectors.toList());
        List<Ico> actIco = icoService.getActiveIco().stream().limit(20).collect(Collectors.toList());

        model.addAttribute("items", items);

        model.addAttribute("upIco", upIco);
        model.addAttribute("finIco", finIco);
        model.addAttribute("actIco", actIco);
        return "welcome";
    }


    @RequestMapping("/{name}")
    public String welcome2(@PathVariable String name) {


        System.out.println();
        return "welcome";
    }

    @RequestMapping("/beginners")
    public String begginers() {

        return "begginers";
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
//        List<Item> items = itemService.findall();
//
//        List<Ico> upIco = icoService.getUpcomingIco();
//        List<Ico> finIco = icoService.getFinishedIco();
//        List<Ico> actIco = icoService.getActiveIco();
//
//        model.addAttribute("items", items);
//
//        model.addAttribute("upIco", upIco);
//        model.addAttribute("finIco", finIco);
//        model.addAttribute("actIco", actIco);

        List<Item> items = rssService.getItems("https://news.tut.by/rss/index.rss");

        model.addAttribute("items",items);

        return "test";
    }

}

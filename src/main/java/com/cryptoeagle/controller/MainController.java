package com.cryptoeagle.controller;


import com.cryptoeagle.entity.*;
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

    @Autowired
    CryptoService cryptoService;

    @ModelAttribute("blog")
    public Blog contructBlog() {
        return new Blog();
    }


    @RequestMapping("/")
    public String welcome(Model model) {

        List<Item> items = rssService.getItems("https://www.coindesk.com/feed/");
        List<Coin> topcoins = cryptoService.getTopGainCoins();

        model.addAttribute("topcoins",topcoins);
        model.addAttribute("items",items);

        return "welcome";
    }


    @RequestMapping("/{name}")
    public String welcome2(@PathVariable String name) {
        System.out.println();
        return "welcome";
    }

    @RequestMapping("/error")
    public String error() {
        return "error-page";
    }


    @RequestMapping("/beginners")
    public String begginers() {

        return "beginners";
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

        List<Ico> icos = icoService.getFinishedIco();
        model.addAttribute("icos",icos);

        return "test";
    }

}

package com.cryptoeagle.controller;


import com.cryptoeagle.entity.*;
import com.cryptoeagle.service.abst.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    CoinService coinService;

    @ModelAttribute("blog")
    public Blog contructBlog() {
        return new Blog();
    }

    @RequestMapping("/update")
    public String update(Model model) {

        icoService.updateIcos();;

        return "redirect:/";
    }


    @RequestMapping("/")
    public String welcome(Model model) {

        List<Item> rawitems = rssService.getItems("https://www.coindesk.com/feed/");
        List<Item> items = rawitems.stream().limit(6).collect(Collectors.toList());


        Item main = items.get(0);

        List<Item> middle = new ArrayList<>();
        middle.add(items.get(1));
        middle.add(items.get(2));


        List<Coin> topcoins = coinService.getTopGainCoins();
        List<Coin> losercoins = coinService.getTopLoserCoins();

        model.addAttribute("losercoins",losercoins);
        model.addAttribute("topcoins",topcoins);
        model.addAttribute("items",items);
        model.addAttribute("main",main);
        model.addAttribute("middle",middle);

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

        AppUser user = (AppUser)model.asMap().get("user");
        List<Blog> blogs = blogService.findall(user.getId());
        model.addAttribute("blogs", blogs);
        return "blogs";
    }

    @RequestMapping("/test")
    public String test(Model model) {
        List<Item> items = rssService.getItems("https://www.coindesk.com/feed/");
        model.addAttribute("items",items);
        return "test";
    }

}

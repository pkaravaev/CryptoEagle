package com.cryptoeagle.controller;


import com.cryptoeagle.entity.*;
import com.cryptoeagle.exception.UserNotFoundException;
import com.cryptoeagle.service.abst.*;
import org.openjdk.jmh.annotations.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Autowired
    EventService eventService;

    @Autowired
    ParserService parserService;

    @ModelAttribute("blog")
    public Blog contructBlog() {
        return new Blog();
    }


    @RequestMapping("/analitics")
    public String analitics() {
        return "analitics";
    }

    @RequestMapping("/whitelist")
    public String whitelist(Model model) {
        List<WhiteList> whiteLists = parserService.getWhiteList();
        model.addAttribute("whiteLists", whiteLists);
        return "white-list";
    }

    @RequestMapping("/update")
    public String update(Model model) {
        icoService.updateIcos();
        return "redirect:/";
    }

    @RequestMapping("/")
    public String welcome(Model model) {

        List<Item> items = itemService.getAll().stream().limit(10).collect(Collectors.toList());
        List<Item> lowerItems = new ArrayList<>();
        List<Item> averageItems = new ArrayList<>();
        Item topItem = null;
        if (items.size() > 0) {
            topItem = items.get(0);
            averageItems.add(items.get(1));
            averageItems.add(items.get(2));

            lowerItems.add(items.get(3));
            lowerItems.add(items.get(4));
            lowerItems.add(items.get(5));
        }

        List<Coin> topcoins = coinService.getTopGainCoins();
        List<Coin> losercoins = coinService.getTopLoserCoins();
        List<Event> events = eventService.getEvents(6);
        List<Ico> icos = icoService.getActiveIco().stream().limit(6).collect(Collectors.toList());

        model.addAttribute("losercoins", losercoins);
        model.addAttribute("topcoins", topcoins);

        model.addAttribute("topItem", topItem);
        model.addAttribute("lowerItems", lowerItems);
        model.addAttribute("averageItems", averageItems);


        model.addAttribute("icos", icos);
        model.addAttribute("events", events);
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

    @RequestMapping("/news")
    public String news(Model model) {
        List<Item> items = itemService.getAll();
        List<String> sources = itemService.getSources();
        model.addAttribute("items", items);
        model.addAttribute("sources", sources);
        return "news-page";
    }

    @RequestMapping("/news/{source}")
    public String newsBySource(Model model, @PathVariable String source) {
        List<Item> items = itemService.getBySource(source);
        List<String> sources = itemService.getSources();
        model.addAttribute("items", items);
        model.addAttribute("sources", sources);
        return "news-page";
    }

    @RequestMapping("/blogs")
    public String blogs(Model model) {
        AppUser user = (AppUser) model.asMap().get("user");
        List<Blog> blogs = blogService.findall(user.getId());
        model.addAttribute("blogs", blogs);
        return "blogs";
    }

    @RequestMapping("/events")
    public String events(Model model) {
        List<Event> events = eventService.getEvents(50);
        model.addAttribute("events", events);
        return "events-page";
    }

    @RequestMapping("/test")
    public String test(Model model) {
//        List<Item> items = rssService.getItems("https://www.coindesk.com/feed/");
//        model.addAttribute("items", items);

        return "test";
    }

    @RequestMapping("/test2")
    public String test2(Model model) {
        return "test2";
    }


    @ExceptionHandler({UserNotFoundException.class})
    public String handle(Model model) {
         model.addAttribute("error", "User not found");
        return "error-page";
    }


}

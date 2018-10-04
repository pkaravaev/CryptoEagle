package com.cryptoeagle.controller;

import com.cryptoeagle.entity.*;
import com.cryptoeagle.exception.UserNotFoundException;
import com.cryptoeagle.service.UserServiceImpl;
import com.cryptoeagle.service.abst.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
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
    WhiteListService whiteListService;

    @ModelAttribute("blog")
    public Blog contructBlog() {
        return new Blog();
    }

    @RequestMapping("/loginerror")
    public String loginError() {
        return "404";
    }

    @RequestMapping("/analitics")
    public String analitics() {
        return "analitics";
    }

    @RequestMapping("/whitelist")
    public String whitelist(Model model) {
        List<WhiteList> whiteLists = whiteListService.getWhiteList();
        model.addAttribute("whiteLists", whiteLists);
        return "white-list";
    }

    @RequestMapping("/update")
    public String update(Model model) {
        icoService.updateIcos();
        return "redirect:/";
    }

    @RequestMapping(value = { "/", "/welcome"})
    public String welcome(@AuthenticationPrincipal User user, Model model) {

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

        List<Event> events = eventService.getEvents(5);

        List<Ico> icos = icoService.getActiveIco().stream().limit(4).collect(Collectors.toList());


        model.addAttribute("topItem", topItem);
        model.addAttribute("lowerItems", lowerItems);
        model.addAttribute("averageItems", averageItems);


        model.addAttribute("icos", icos);
        model.addAttribute("events", events);

        return "welcome";
    }

    @RequestMapping("/uCoin")
    public String updateCoin(){
        coinService.updateCoins();
        return  "redirect:/welcome ";
    }

    @RequestMapping("/uItem")
    public String updateItem(){
        itemService.updateItems();
        return  "redirect:/welcome ";
    }

    @RequestMapping("/uIco")
    public String updateAll(){
        icoService.updateIcos();
        return  "redirect:/welcome ";
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
        List<Blog> blogs = blogService.getAll().stream().limit(10).collect(Collectors.toList());
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
        List<Item> items = itemService.getAll();
        model.addAttribute("items",items);
        return "test";
    }

    @RequestMapping("/test2")
    public String test2(Model model) {
        return "test2";
    }

    @RequestMapping("/admin")
    public String admin(Model model, Principal principal , Authentication authentication) {
        return "admin-page";
    }

    @ExceptionHandler({UserNotFoundException.class})
    public String handle(Model model) {
         model.addAttribute("error", "User not found");
        return "error-page";
    }

}

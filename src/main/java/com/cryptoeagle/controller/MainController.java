package com.cryptoeagle.controller;


import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.entity.dto.CryptoCoin;
import com.cryptoeagle.service.abst.BlogService;
import com.cryptoeagle.service.abst.CryptoService;
import com.cryptoeagle.service.abst.ItemService;
import com.cryptoeagle.service.abst.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
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
    CryptoService cryptoService;

    @ModelAttribute("blog")
    public Blog contructBlog() {
        return new Blog();
    }


    @RequestMapping("/")
    public String welcome(Model model) {
        List<Item> items = itemService.findall();
        model.addAttribute("items", items);
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
        model.addAttribute("items", items);
        return "test";
    }

    @RequestMapping(value = "/ajax/coins", produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public List<CryptoCoin> getPriceCoins(Model model) {
        List<CryptoCoin> coins = cryptoService.getCoins();
        return coins;
    }


}

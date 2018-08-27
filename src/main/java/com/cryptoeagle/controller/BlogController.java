package com.cryptoeagle.controller;


import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.exception.RssNewsNotFoundException;
import com.cryptoeagle.service.abst.BlogService;
import com.cryptoeagle.service.abst.RssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes("user")
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    RssService rssService;

    @RequestMapping("/blog/remove")
    public String remove(@RequestParam String name) {
       //todo blogService delete byName
        return "redirect:/blogs";
    }

    @RequestMapping("/blog/add")
    public String add(@RequestParam String name, @RequestParam String url, @SessionAttribute("user") AppUser user) {

        Blog blog = new Blog();
        blog.setName(name);
        blog.setUrl(url);
        blog.setAppUser(user);

        List<Item> items = rssService.getItems(url);
        if (items != null) {
            blog.setItems(items);
            blog.setAppUser(user);
        }
        else
            throw new RssNewsNotFoundException(url);

        blogService.save(blog, user.getId());
        return "redirect:/user-profile";
    }
}

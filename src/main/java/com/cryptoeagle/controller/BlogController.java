package com.cryptoeagle.controller;


import com.cryptoeagle.entity.User;
import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.exception.RssNewsNotFoundException;
import com.cryptoeagle.service.abst.BlogService;
import com.cryptoeagle.service.abst.RssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    RssService rssService;

    @RequestMapping("/blog/remove")
    public String remove(@RequestParam String name) {
        blogService.deleteByName(name);
        return "redirect:/user-profile";
    }

    @RequestMapping("/blog/add")
    public String add(@RequestParam String name, @RequestParam String url, @AuthenticationPrincipal User user) {

        Blog blog = new Blog();
        blog.setName(name);
        blog.setUrl(url);
        blog.setUser(user);

        List<Item> items = rssService.getItems(url);
        if (items != null) {
            blog.setItems(items);
            blog.setUser(user);
        }
        else
            throw new RssNewsNotFoundException(url);

        blogService.save(blog, user.getId());
        return "redirect:/user-profile";
    }
}

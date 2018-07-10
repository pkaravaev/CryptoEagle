package com.cryptoeagle.controller;


import com.cryptoeagle.entity.Item;
import com.cryptoeagle.entity.User;
import com.cryptoeagle.repository.ItemRepository;
import com.cryptoeagle.repository.UserRepository;
import com.cryptoeagle.service.ItemService;
import com.cryptoeagle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@SessionAttributes("user")
public class MainController {

    @Autowired
    ItemService service;

    @RequestMapping("/")
    public String welcome(HttpSession session, Model model) {
//        int user_id = (int)session.getAttribute("user");
        List<Item> items = service.findall();
        model.addAttribute("items",items);
        System.out.println();
        return "welcome";
    }

}

package com.cryptoeagle.controller;


import com.cryptoeagle.entity.User;
import com.cryptoeagle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes("user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "loginform";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String logining(@RequestParam String email, @RequestParam String password, HttpSession session) {
        User user = userService.getByEmail(email);
        session.setAttribute("user",user);
        return "redirect:/";
    }

    @RequestMapping("/users")
    public String users(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute(users);
        return "users";
    }

    @RequestMapping("/users/delete/{id}")
    public String deleteUsers(@PathVariable int id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @RequestMapping("/users/edit/{id}")
    public String editUsers(@PathVariable int id, Model model) {
        User user = userService.get(id);
        model.addAttribute("user", user);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String createUser(@RequestParam String name,
                             @RequestParam String email,
                             @RequestParam String password,
                             @RequestParam String password_again) {

        User user = new User(name, email, password, true, false);
        userService.save(user);
        return "register";
    }
}

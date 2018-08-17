package com.cryptoeagle.controller;


import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.service.abst.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes("user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "redirect:/";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session, SessionStatus status) {
        status.setComplete();
        session.removeAttribute("user");
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String logining(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        AppUser appUser = userService.getByEmail(email);
        if (appUser == null){
            model.addAttribute("error","User not found!!!");
            return "error-page";
        }
        model.addAttribute("user", appUser);
        return "user-profile";
    }

    @RequestMapping("/users")
    public String users(Model model) {
        List<AppUser> appUsers = userService.findAll();
        model.addAttribute("users", appUsers);
        return "users";
    }

    @RequestMapping("/users/delete/{id}")
    public String deleteUsers(@PathVariable int id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @RequestMapping("/users/edit/{id}")
    public String editUsers(@PathVariable int id, Model model) {
        AppUser appUser = userService.get(id);
        model.addAttribute("user", appUser);
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
                             @RequestParam String password_again, Model model) {
        AppUser appUser = new AppUser(name, email, password, true, false);
        model.addAttribute("register", true);
        model.addAttribute("name", name);
        userService.save(appUser);
        return "redirect:/";
    }
}

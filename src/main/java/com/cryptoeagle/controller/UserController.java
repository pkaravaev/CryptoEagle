package com.cryptoeagle.controller;


import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Role;
import com.cryptoeagle.entity.User;
import com.cryptoeagle.service.abst.BlogService;
import com.cryptoeagle.service.abst.ItemService;
import com.cryptoeagle.service.abst.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    BlogService blogService;

    @Autowired
    ItemService itemService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String login() {
        return "login-page";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session, SessionStatus status) {
        session.invalidate();
        return "redirect:/";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String logining(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
//        User user = userService.getByEmail(email);
//        if (user == null) {
//            model.addAttribute("error", "User not found!!!");
//            return "error-page";
//        }
//        List<Item> list = blogService.itemsFromBlogs(user.getId());
//        model.addAttribute("blogs", list);
//        model.addAttribute("user", user);
//        return "redirect:/user-profile";
//    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(){
        return "redirect:/user-profile";
    }

    @RequestMapping("/user-profile")
    public String userProfile(@AuthenticationPrincipal User user, Model model) {
        List<Blog> blogs = blogService.findall(user.getId());
        model.addAttribute("blogs", blogs);
        model.addAttribute("name", user.getUsername());
        return "user-profile";

    }

    @RequestMapping("/users")
    public String users(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
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
                             @RequestParam String password_again, Model model) {
        User user = new User(name, email, passwordEncoder.encode(password), true);
        user.setRoles(Role.USER);

        model.addAttribute("register", true);
        model.addAttribute("name", name);
        userService.saveAndUpdate(user);
        return "redirect:/";
    }
}

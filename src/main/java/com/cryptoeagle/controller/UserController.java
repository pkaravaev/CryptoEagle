package com.cryptoeagle.controller;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Role;
import com.cryptoeagle.entity.User;
import com.cryptoeagle.exception.UserAlreadyExistException;
import com.cryptoeagle.exception.UserValidationException;
import com.cryptoeagle.service.abst.BlogService;
import com.cryptoeagle.service.abst.ItemService;
import com.cryptoeagle.service.abst.UserService;
import org.glassfish.jersey.internal.guava.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


    @RequestMapping("/user-profile")
    public String userProfile(@AuthenticationPrincipal User user, Model model) {
        User userFromDb = userService.get(user.getId());
        model.addAttribute("blogs", userFromDb.getBlogs());
        model.addAttribute("name", userFromDb.getUsername());
        return "user-profile";
    }

    @RequestMapping("/users")
    public String users(@AuthenticationPrincipal User user, Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping("/users/delete/{id}")
    public String deleteUser(@AuthenticationPrincipal User user, @PathVariable int id, Model model) {
        if (user.getId() == id) {
            return "redirect:/admin-page";
        }
        userService.delete(id);
        return "redirect:/admin-page";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String createUser(@ModelAttribute @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new UserValidationException(bindingResult.getFieldError().getDefaultMessage());
        User userByEmail = userService.getByEmail(user.getEmail());
        if (userByEmail != null)
            throw new UserAlreadyExistException(" User already exist!!!");

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(new Role("USER"));
        user.setRoles(roleSet);
        userService.saveAndUpdate(user);
        return "redirect:/";
    }

}

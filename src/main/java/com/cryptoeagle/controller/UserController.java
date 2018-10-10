package com.cryptoeagle.controller;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Role;
import com.cryptoeagle.entity.User;
import com.cryptoeagle.exception.UserAlreadyExistException;
import com.cryptoeagle.exception.UserValidationException;
import com.cryptoeagle.service.abst.BlogService;
import com.cryptoeagle.service.abst.ItemService;
import com.cryptoeagle.service.abst.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

        List<Blog> blogs = blogService.findall(user.getId());
        model.addAttribute("blogs", blogs);
        model.addAttribute("name", user.getUsername());
        return "user-profile";
    }

    @RequestMapping("/users")
    public String users(@AuthenticationPrincipal User user, Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping("/users/delete/{id}")
    public String deleteUsers(@AuthenticationPrincipal User user, @PathVariable int id, Model model) {
        if (user.getId() == id){
            model.addAttribute("error","This is current user!!");
            return "admin-page";
        }
        userService.delete(id);
        model.addAttribute("success","Success!!");
        return "admin-page";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new UserValidationException(bindingResult.getFieldError().getDefaultMessage());
        }

        User byEmail = userService.getByEmail(user.getUsername());

        if (byEmail != null) {
            throw new UserAlreadyExistException();
        }

        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        Role roleUser = new Role("USER");

        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleUser);

        user.setRoles(roleSet);
        userService.saveAndUpdate(user);

        return "redirect:/";
    }
}

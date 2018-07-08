package com.cryptoeagle.controller;


import com.cryptoeagle.entity.User;
import com.cryptoeagle.repository.UserRepository;
import com.cryptoeagle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletRequest;
import java.util.List;


@Controller
public class MainController {


    @RequestMapping("/")
    public String welcome() {
        return "welcome";
    }

}

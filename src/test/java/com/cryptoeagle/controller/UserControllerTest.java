package com.cryptoeagle.controller;

import com.cryptoeagle.AbstractWebController;
import com.cryptoeagle.entity.User;
import com.cryptoeagle.service.abst.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithUserDetails;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class UserControllerTest extends AbstractWebController {

    private static final int USER1_ID = 100089;

    @Autowired
    UserService userService;

    @Test
    @WithUserDetails("user2")
    public void logOut() throws Exception {
        mockMvc
                .perform(logout())
                .andDo(print())
                .andExpect(redirectedUrl("/welcome"));
    }

    @Test
    @WithUserDetails("admin")
    public void users() throws Exception {
        mockMvc
                .perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("users", hasSize(4)))
                .andExpect(model().attribute("users", hasItems(
                        allOf(
                                hasProperty("name"),
                                hasProperty("email"),
                                hasProperty("roles"),
                                hasProperty("blogs"),
                                hasProperty("password")
                        )
                )))
                .andExpect(view().name("users"));
    }

    @Test
    @WithUserDetails("admin")
    public void deleteUsers() throws Exception {
        mockMvc
                .perform(get("/users/delete/" + USER1_ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("admin-page"));

        List<User> all = userService.findAll();
        Assert.assertTrue(all.size() == 3);
    }

    @Test
    @WithUserDetails("admin")
    public void userProfile() throws Exception {
        mockMvc
                .perform(get("/user-profile"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("blogs", hasSize(0)))
                .andExpect(view().name("user-profile"));
    }

    @Test
    @WithUserDetails("user2")
    public void userProfileUser() throws Exception {
        mockMvc
                .perform(get("/user-profile"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("blogs", hasSize(3)))
                .andExpect(model().attribute("name", is("user2")))
                .andExpect(view().name("user-profile"));
    }

    @Test
    public void createUser() throws Exception {
        mockMvc
                .perform(post("/register")
                        .param("name","test_user")
                        .param("email","test_user@mail.ru")
                        .param("password", "q1w2e3r4t5"))
                .andExpect(redirectedUrl("/"));

        List<User> all = userService.findAll();
         Assert.assertTrue(all.size() == 5);
    }

}
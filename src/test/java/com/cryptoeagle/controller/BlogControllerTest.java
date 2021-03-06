package com.cryptoeagle.controller;

import com.cryptoeagle.AbstractWebController;
import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.service.abst.BlogService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithUserDetails;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BlogControllerTest extends AbstractWebController {

    private static final  int BLOG_COUNT = 8;


    @Autowired
    BlogService blogService;

    @Test
    public void remove() throws Exception {
        mockMvc.perform(get("/blog/remove").param("name", "cryptopotato"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/user-profile"));
        List<Blog> all = blogService.getAll();
        assertTrue(all.size() == BLOG_COUNT - 1);
    }

    @Test
    @WithUserDetails("user2")
    public void add() throws Exception {
        mockMvc.perform(get("/blog/add").param("name", "newzcrypto").param("url", "http://www.newzcrypto.com/feed/"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/user-profile"));
        List<Blog> all = blogService.getAll();
        assertTrue(all.size() == BLOG_COUNT + 1);
    }

}
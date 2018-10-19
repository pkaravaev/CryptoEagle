package com.cryptoeagle.controller;

import com.cryptoeagle.AbstractWebController;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class TestControllerTest extends AbstractWebController {

    @Test
    public void test1() throws Exception {
        mockMvc
                .perform(get("/test"))
                .andExpect(status().isOk())
                .andExpect(view().name("test"));
    }

    @Test
    public void populateAll() throws Exception {

        //todo incorect work
        try {
            mockMvc
                    .perform(get("/populate"));
        } catch (Exception e) {

        }


    }
}
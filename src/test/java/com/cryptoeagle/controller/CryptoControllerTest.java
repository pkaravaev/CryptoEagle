package com.cryptoeagle.controller;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class CryptoControllerTest extends AbstractControllerTest {

    @Test
    public void icoStats()throws Exception {
        mvc
                .perform(get("/ico-stats"))
                .andExpect(status().isOk())
                .andExpect(view().name("ico-stats"));
    }

    @Test
    public void icoList()throws Exception {
        mvc
                .perform(get("/ico-list"))
                .andExpect(status().isOk())
                .andExpect(view().name("ico-list"));
    }

    @Test
    public void coinList()throws Exception {
        mvc
                .perform(get("/coin-list"))
                .andExpect(status().isOk())
                .andExpect(view().name("coin-list"));
    }

    @Test
    public void icoPage()throws Exception {
        mvc
                .perform(get("/ico-page/test"))
                .andExpect(status().isOk())
                .andExpect(view().name("ico-page"));
    }
}
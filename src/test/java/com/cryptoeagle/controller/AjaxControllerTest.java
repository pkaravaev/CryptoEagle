package com.cryptoeagle.controller;

import com.cryptoeagle.AbstractWebController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class AjaxControllerTest extends AbstractWebController {

    private static final String AJAX_PATH = "/ajax/";

    private static final int COINS_COUNT = 10;

    private static final int COINS_PRICE_COUNT = 4;

    private static final String SYMBOL = "ETH";


    @Test
    public void getPriceCoins() throws Exception {
        testCoins(AJAX_PATH + "coins", COINS_PRICE_COUNT);
    }

    @Test
    public void getCharts() throws Exception {

        mockMvc.perform(get(AJAX_PATH + "coins/" + SYMBOL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(420)))
                .andExpect(jsonPath("$[0].x", notNullValue()))
                .andExpect(jsonPath("$[0].y", notNullValue()));
    }

    @Test
    public void getGetLooseCoins() throws Exception {
        testCoins(AJAX_PATH + "loosercoins", COINS_COUNT);
    }

    @Test
    public void getGetTopCoins() throws Exception {
        testCoins(AJAX_PATH + "topcoins", COINS_COUNT);
    }


    private void testCoins(String path, int count) throws Exception {

        mockMvc
                .perform(get(path))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(count)))
                .andExpect(jsonPath("$[0].id", notNullValue()))
                .andExpect(jsonPath("$[0].name", notNullValue()))
                .andExpect(jsonPath("$[0].image", notNullValue()))
                .andExpect(jsonPath("$[0].symbol", notNullValue()))
                .andExpect(jsonPath("$[0].circulating_supply", notNullValue()))
                .andExpect(jsonPath("$[0].price", notNullValue()))
                .andExpect(jsonPath("$[0].volume_24h", notNullValue()))
                .andExpect(jsonPath("$[0].market_cap", notNullValue()))
                .andExpect(jsonPath("$[0].percent_change_1h", notNullValue()))
                .andExpect(jsonPath("$[0].percent_change_7d", notNullValue()))
                .andExpect(jsonPath("$[0].percent_change_24h", notNullValue()))
                .andExpect(jsonPath("$[0].dataAvailable", notNullValue()));
    }
}
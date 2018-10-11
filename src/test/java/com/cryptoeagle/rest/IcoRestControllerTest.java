package com.cryptoeagle.rest;

import com.cryptoeagle.AbstractWebController;
import org.apache.xerces.util.HTTPInputSource;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class IcoRestControllerTest extends AbstractWebController {

    private static final String PATH = "/api/";

    private static final String ICO_ALL = "icos";

    private static final String ICO_UPCOMING = "icos/upcoming";
    private static final String ICO_FINISHED = "icos/finishied";
    private static final String ICO_ACTIVE = "icos/active";

    private static final String ICO_NAME = "Virtual Rehab";


    @Test
    public void retrieveAllIcos() throws Exception {
        testIco(PATH + ICO_ALL, 8);
    }

    @Test
    public void retrieveUpcoming() throws Exception {
        testIco(PATH + ICO_UPCOMING, 5);
    }

    @Test
    public void retrieveFinished() throws Exception {

        mockMvc.perform(get(PATH + ICO_FINISHED))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(0)));

    }

    @Test
    public void retrieveActice() throws Exception {

        testIco(PATH + ICO_ACTIVE, 3);

    }

    @Test
    public void getIcoWithData() throws Exception {


        //TODO work not correct
        testIco(PATH + ICO_ALL + ICO_NAME, 0);

    }


    private void testIco(String path, int count) throws Exception {

        mockMvc.perform(get(path))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(count)))
                .andExpect(jsonPath("$[0].name", notNullValue()))
                .andExpect(jsonPath("$[0].logolink", notNullValue()))
                .andExpect(jsonPath("$[0].description", notNullValue()))
                .andExpect(jsonPath("$[0].website_link", notNullValue()))

                .andExpect(jsonPath("$[0].rating", notNullValue()))
                .andExpect(jsonPath("$[0].page", notNullValue()))
                .andExpect(jsonPath("$[0].preIcoStart", notNullValue()))
                .andExpect(jsonPath("$[0].preIcoEnd", notNullValue()))
                .andExpect(jsonPath("$[0].icoStart", notNullValue()))
                .andExpect(jsonPath("$[0].icoEnd", notNullValue()));

    }


    @ExceptionHandler
    public ResponseEntity<Object> icoNotFound() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
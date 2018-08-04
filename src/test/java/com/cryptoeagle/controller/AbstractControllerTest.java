package com.cryptoeagle.controller;


import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring/spring-app.xml","/spring/spring-db.xml", "/spring/spring-mvc.xml"})
@WebAppConfiguration
@ActiveProfiles({"Jpa","PostgreSQL"})
public  abstract class AbstractControllerTest {

    @Autowired
    protected WebApplicationContext context;

    protected MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }
}

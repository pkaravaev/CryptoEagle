package com.cryptoeagle.service;


import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration({"/spring/spring-app.xml","/spring/spring-db.xml"})
@RunWith(SpringRunner.class)
@ActiveProfiles({"Jpa","PostgreSQL"})
public class AbstractTest {
}

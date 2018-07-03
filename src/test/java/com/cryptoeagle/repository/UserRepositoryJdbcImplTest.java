package com.cryptoeagle.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


@ContextConfiguration({"classpath*:/spring/spring-db.xml",
                                  "classpath*:/spring/spring-app.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = {"classpath:db/initdb.sql", "classpath:/db/populate.sql"})

public class UserRepositoryJdbcImplTest {

    @Autowired
    UserRepository repository;

    @Before
    public void setUp() throws Exception {



    }

    @Test
    public void save() {

        System.out.println();
    }

    @Test
    public void delete() {
    }

    @Test
    public void get() {
    }

    @Test
    public void getall() {
    }
}
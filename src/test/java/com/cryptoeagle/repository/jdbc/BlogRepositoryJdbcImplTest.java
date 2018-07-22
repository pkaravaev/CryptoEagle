package com.cryptoeagle.repository.jdbc;

import com.cryptoeagle.service.abst.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static org.junit.Assert.assertEquals;


@ContextConfiguration({"classpath:/spring/spring-db.xml",
        "classpath:/spring/spring-app.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = {"classpath:db/initdb.sql", "classpath:/db/populate.sql"})
@ActiveProfiles(  {"PostgreSQL","Jdbc"  })
public class BlogRepositoryJdbcImplTest {

    @Autowired
    BlogService service;

    @Test
    public void save() {
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
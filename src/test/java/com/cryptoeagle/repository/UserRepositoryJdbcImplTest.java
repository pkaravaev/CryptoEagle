package com.cryptoeagle.repository;

import com.cryptoeagle.entity.User;
import com.cryptoeagle.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//
//@ContextConfiguration({"classpath*:/spring/spring-db.xml",
//        "classpath*:/WEB-INF/applicationContext.xml"})
//@RunWith(SpringJUnit4ClassRunner.class)
//@Sql(scripts = {"classpath:db/initdb.sql", "classpath:/db/populate.sql"})

public class UserRepositoryJdbcImplTest {

//    @Autowired
//    UserRepository repository;
//
//    @Autowired
//    UserService service;

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

//        List<User> getall = repository.getall();

        System.out.println();
    }
}
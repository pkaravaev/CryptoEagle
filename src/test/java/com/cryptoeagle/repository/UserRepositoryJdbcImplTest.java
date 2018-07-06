package com.cryptoeagle.repository;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.User;
import com.cryptoeagle.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@ContextConfiguration({"classpath:/spring/spring-db.xml",
        "classpath:/spring/spring-app.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = {"classpath:db/initdb.sql", "classpath:/db/populate.sql"})

public class UserRepositoryJdbcImplTest {

    @Autowired
    UserRepository repository;

    @Autowired
    UserService service;

    @Autowired
    DataSource dataSource;

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void save() {


        User user = new User("vasya", "xxxx@gmail.com", "q1w2e34rt4t4", true, false );

        repository.save(user);


        User user2 = new User("sgsdgsdgsd", "xxxx@gmail.com", "vcbcbcvbbc", true, false );
        user2.setId(100);

        repository.save(user2);

    }

    @Test
    public void delete() {
    }

    @Test
    public void get() {
    }

    @Test
    public void getall() {

        List<User> getall = repository.getall();

        System.out.println();
    }
}
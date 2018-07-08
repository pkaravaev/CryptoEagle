package com.cryptoeagle.repository.jdbc;

import com.cryptoeagle.TestData;
import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.User;
import com.cryptoeagle.repository.UserRepository;
import com.cryptoeagle.service.UserService;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.cryptoeagle.TestData.*;
import static org.junit.Assert.assertEquals;


@ContextConfiguration({"classpath:/spring/spring-db.xml",
        "classpath:/spring/spring-app.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = {"classpath:db/initdb.sql", "classpath:/db/populate.sql"})

public class UserRepositoryJdbcImplTest {

    @Autowired
    UserRepository repository;

    @Autowired
    UserService service;

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void save() {
        repository.save(USER_1);
        List<User> getall = repository.getall();
        assertEquals(COUNT_USERS + 1,getall.size() );

    }

    @Test
    public void delete() {
        service.delete(USER_ID);
        List<User> getall = repository.getall();
        assertEquals(COUNT_USERS - 1,getall.size() );
    }

    @Test
    public void get() {
        User user = repository.get(204);
        assertEquals(user.getId(), 203);
    }

    @Test
    public void getall() {
        List<User> getall = repository.getall();
        assertEquals(COUNT_USERS,getall.size() );
    }

    @Test
    public void getallWithBlogs() {
        List<User> getall = repository.getAllWithBlogs();
        assertEquals(COUNT_USERS,getall.size() );
    }
}
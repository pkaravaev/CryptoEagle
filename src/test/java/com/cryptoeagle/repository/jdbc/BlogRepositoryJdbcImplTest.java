package com.cryptoeagle.repository.jdbc;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.repository.BlogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


import static com.cryptoeagle.UserTestData.USER_ID;
import static org.junit.Assert.assertEquals;


@ContextConfiguration({"classpath:/spring/spring-db.xml",
        "classpath:/spring/spring-app.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = {"classpath:db/initdb.sql", "classpath:/db/populate.sql"})
public class BlogRepositoryJdbcImplTest {

    @Autowired
    BlogRepository repository;

    @Test
    public void save() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void get() {

        Blog blog = repository.get(10004, 202);
    }

    @Test
    public void getall() {
        List<Blog> getall = repository.getall(USER_ID);

    }
}
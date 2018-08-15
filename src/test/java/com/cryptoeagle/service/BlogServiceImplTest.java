package com.cryptoeagle.service;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.service.abst.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.cryptoeagle.TestData.BLOG1;
import static com.cryptoeagle.TestData.BLOG3;
import static com.cryptoeagle.TestData.BLOG3_UPDATE;
import static org.junit.Assert.*;


public class BlogServiceImplTest extends AbstractTest {

    @Autowired
    BlogService service;

    @Test
    public void save() {

         service.save(BLOG1,1);
    }

    @Test
    public void update() {

        service.save(BLOG3,1);

        service.update(BLOG3_UPDATE,1);
    }

    @Test
    public void findall() {
        List<Blog> findallUser1 = service.findall(100);
        assertTrue(findallUser1.size() == 2);
    }

    @Test
    public void itemsFromBlogs() {
    }

    @Test
    public void delete() {
        service.delete(100,1000);
        List<Blog> findallUser1 = service.findall(100);
        assertTrue(findallUser1.size() == 1);
    }

}
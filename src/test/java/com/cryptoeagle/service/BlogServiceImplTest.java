package com.cryptoeagle.service;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;
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

import static com.cryptoeagle.TestData.*;
import static org.junit.Assert.*;


public class BlogServiceImplTest extends AbstractTest {

    @Autowired
    BlogService service;

    @Test
    public void save() {
         service.save(BLOG10,USER5.getId());
        List<Blog> all = service.getAll();
        assertTrue(BLOG_COUNT + 1== all.size());
    }

    @Test
    public void update() {
        service.update(BLOG3_UPDATE, BLOG3_UPDATE.getId());
        List<Blog> blogs = service.findall(BLOG3_UPDATE.getId());
        System.out.println();
    }

    @Test
    public void findall() {

        List<Blog> all = service.getAll();
        List<Blog> blogs = service.findall(100);
        assertTrue(blogs.size() == 2);
        List<Blog> blogs2 = service.findall(104);
        assertTrue(blogs2.size() == 1);
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

    @Test
    public void deleteByName() {
        service.delete(100,1000);
        List<Blog> findallUser1 = service.findall(100);
        assertTrue(findallUser1.size() == 1);
    }

    @Test
    public void getAll() {
        List<Blog> all = service.getAll();
        assertTrue(all.size() == 9);
    }

    @Test
    public void updateFromRss(){
        service.updateFromRss();
    }

}
package com.cryptoeagle.service;

import com.cryptoeagle.AbstractTest;
import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.User;
import com.cryptoeagle.service.abst.BlogService;
import com.cryptoeagle.service.abst.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithUserDetails;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class BlogServiceImplTest extends AbstractTest {

    private static final int USER1_ID = 100089;
    private static final int USER1_BLOG_COUNT = 4;
    private static final int BLOG_COUNT = 8;
    private static final int BLOG_ID = 100172;
    private static final String BLOG_NAME = "minergate";

    @Autowired
    BlogService service;

    @Test
    public void deleteByName() {
        service.deleteByName(BLOG_NAME);
        List<Blog> all = service.getAll();
        assertTrue(all.size() == BLOG_COUNT - 1);
    }

    @Test
    public void save() {
        Blog blog = new Blog("coingape", "https://coingape.com/feed/");
        User user = new User();
        user.setName("test_user");
        user.setPassword("test_password");
        user.setEmail("test_email");
        service.save(blog, user);

        List<Blog> all = service.getAll();
        assertTrue(all.size() == BLOG_COUNT + 1);
    }

    @Test
    public void findAllByUser() {
        List<Blog> all = service.findAllByUser(USER1_ID);
        assertTrue(all.size() == USER1_BLOG_COUNT);
    }

    @Test
    public void getByName() {
        Blog blog = service.getByName(BLOG_NAME);
        assertTrue(blog.getName().equals(BLOG_NAME));
    }

    @Test
    public void delete() {
        service.delete(BLOG_ID);
        List<Blog> all = service.getAll();
        assertTrue(all.size() == BLOG_COUNT - 1);
    }

    @Test
    public void getAll() {
        List<Blog> all = service.getAll();
        assertTrue(all.size() == BLOG_COUNT);
    }

    @Test
    public void update() {
        service.update();
    }

}
package com.cryptoeagle.repository;

import com.cryptoeagle.UserTestData;
import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.service.abst.BlogService;
import com.cryptoeagle.service.abst.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.cryptoeagle.BlogTestData.*;
import static com.cryptoeagle.UserTestData.*;
import static org.junit.Assert.assertEquals;

public class AbstractBlogServiceTest extends AbstractServiceTest {

    @Autowired
    BlogService blogService ;
    @Autowired
    UserService userService;

    @Test
    public void save() {

        blog1.setAppUser(UserTestData.appUser1);
        blogService.save(blog1,UserTestData.USER_ID);
        AppUser user = userService.get(USER_ID);
        assertEquals(user.getBlogs().size(), COUNT_BLOGS + 1);
    }

    @Test
    public void update() {


        blogService.save(BLOG_UPDATE,USER_ID);

//        AppUser user = userService.get(USER_ID);
//        assertEquals(user.getBlogs().size(), COUNT_BLOGS);
    }

    @Test
    public void findall() {
        List<Blog> blogs = blogService.findall(UserTestData.USER_ID);
        assertEquals(blogs.size(), COUNT_BLOGS);
    }
}


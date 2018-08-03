package com.cryptoeagle.repository;

import com.cryptoeagle.UserTestData;
import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.service.abst.BlogService;
import com.cryptoeagle.service.abst.UserService;
import org.hsqldb.rights.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static com.cryptoeagle.BlogTestData.*;
import static com.cryptoeagle.UserTestData.*;
import static org.junit.Assert.assertEquals;

public class AbstractBlogTest extends AbstractTest {

    @Autowired
    BlogService blogService;
    @Autowired
    UserService userService;

    @Test
    public void save() {

        AppUser user = new AppUser();
        user.setName("Pavel");
        user.setEmail("blabla@gmail.com");
        user.setAdmin(true);
        user.setAdmin(true);

        Item item = new Item("Item1", "item1 description", null, "www");
        Item item1 = new Item("Item2", "item2 description", null, "www2");
        Item item2 = new Item("Item3", "item3 description", null, "www3");
        Item item3 = new Item("Item4", "item4 description", null, "www4");


        Blog blog = new Blog("xxxxblog", "abaddgag.com");
        blog.setItems(Arrays.asList(item,item1));
        item.setBlog(blog);
        item1.setBlog(blog);
        blog.setAppUser(user);

        Blog blog2 = new Blog("gdgblog", "sfs.com");
        blog2.setItems(Arrays.asList(item2));
        blog2.setAppUser(user);
        item2.setBlog(blog2);

        Blog blog3 = new Blog("ygyBlog", "abadsfdsddgag.com");
        blog3.setItems(Arrays.asList(item3));
        blog3.setAppUser(user);
        item3.setBlog(blog3);

        user.setBlogs(Arrays.asList(blog, blog2, blog3));

        userService.save(user);
    }

    @Test
    public void update() {


//        blogService.save(BLOG_UPDATE,USER_ID);

//        AppUser user = userService.get(USER_ID);
//        assertEquals(user.getBlogs().size(), COUNT_BLOGS);
    }

    @Test
    public void findall() {
//        List<Blog> blogs = blogService.findall(UserTestData.USER_ID);
//        assertEquals(blogs.size(), COUNT_BLOGS);
    }
}


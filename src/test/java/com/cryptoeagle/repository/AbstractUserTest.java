package com.cryptoeagle.repository;

import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.service.abst.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.cryptoeagle.UserTestData.*;
import static org.junit.Assert.assertEquals;


public class AbstractUserTest extends AbstractTest {

    @Autowired
    UserService service;

    @Test
    public void save() {
        service.save(appUser1);
    }

    @Test
    public void delete() {
        service.delete(102);
    }

    @Test
    public void get() {
        AppUser appUser = service.get(100);
    }

    @Test
    public void getByEmail() {
        AppUser user = service.getByEmail("vasya@mail.ru");
        assertEquals(user.getId(), USER_ID);
    }

    @Test
    public void getall() {
        List<AppUser> getall = service.findAll();
        assertEquals(getall.size(), COUNT_USERS);
    }

    @Test
    public void getAllWithBlogs() {
        List<AppUser> users = service.findAll();
        AppUser user = users.stream().filter(e -> e.getId() == USER_ID).findFirst().get();
        assertEquals(user.getBlogs().size(), COUNT_BLOGS);
        assertEquals(users.size(), COUNT_USERS);
    }
}

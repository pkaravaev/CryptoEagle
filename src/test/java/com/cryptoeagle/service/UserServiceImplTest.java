package com.cryptoeagle.service;

import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.service.abst.UserService;
import org.glassfish.jersey.jaxb.internal.XmlJaxbElementProvider;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.cryptoeagle.TestData.USER1;
import static com.cryptoeagle.TestData.USER2;
import static org.junit.Assert.*;

public class UserServiceImplTest  extends AbstractTest{

    @Autowired
    UserService service;

    @Test
    public void findAll() {
        List<AppUser> all = service.findAll();
        assertTrue(all.size() == 3);
    }

    @Test
    public void save() {
        AppUser user3 = new AppUser("user3","user3@gmail.com","q1w2e3r4t5", true, true);
        service.save(user3);
        List<AppUser> all = service.findAll();
        assertTrue(all.size() == 4);
    }

    @Test
    public void get() {
        AppUser user = service.get(100);
        assertTrue(user != null);
    }

    @Test
    public void getByEmail() {
        AppUser byEmail = service.getByEmail("vasya@mail.ru");
        assertTrue(byEmail != null);
    }

    @Test
    public void delete() {
        service.delete(101);
        List<AppUser> users = service.findAll();
        assertTrue(users.size() == 2);
    }

    @Test
    public void findAmin() {
        AppUser admin = service.findAmin();
        assertTrue(admin.isAdmin() == true);
    }
}
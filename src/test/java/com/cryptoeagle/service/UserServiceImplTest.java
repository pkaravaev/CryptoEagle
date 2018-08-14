package com.cryptoeagle.service;

import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.service.abst.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.cryptoeagle.TestData.USER1;
import static com.cryptoeagle.TestData.USER2;
import static org.junit.Assert.*;

public class UserServiceImplTest  extends AbstractTest{

    @Autowired
    UserService service;

    @Test
    public void findAll() {
    }

    @Test
    public void save() {
        service.save(USER1);
    }

    @Test
    public void get() {


    }

    @Test
    public void getByEmail() {

        AppUser byEmail = service.getByEmail("andrey@gmail.com");

        assertTrue(byEmail != null);
    }

    @Test
    public void delete() {
    }

    @Test
    public void delete1() {
    }

    @Test
    public void findAmin() {
    }
}
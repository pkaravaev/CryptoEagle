package com.cryptoeagle.service;


import com.cryptoeagle.entity.User;
import com.cryptoeagle.exception.UserNotFoundException;
import com.cryptoeagle.service.abst.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class UserServiceImplTest  extends AbstractTest{

    private static final int USERS_COUNT = 3;

    private static final int USER1_ID = 100086;
    private static final int USER2_ID = 100089;
    private static final int USER3_ID = 100092;
    private static final int USER4_ID = 100095;

    @Autowired
    UserService service;

    @Test
    public void findAll() {
        List<User> all = service.findAll();
        assertTrue(all.size() == USERS_COUNT);
    }
//
//    @Test
//    public void save() {
//        service.saveAndUpdate(USER6);
//        List<User> all = service.findAll();
//        assertTrue(all.size() == 6);
//    }
//
//    @Test
//    public void update() {
//        service.saveAndUpdate(USER4_UPDATE);
//        User user = service.get(USER4_UPDATE.getId());
//        assertTrue(user.getEmail().equals(USER4_UPDATE.getEmail()));
//        assertTrue(user.getName().equals(USER4_UPDATE.getName()));
//        assertTrue(user.getPassword().equals(USER4_UPDATE.getPassword()));
//    }
//
//    @Test
//    public void get() {
//        User user = service.get(USER3.getId());
//
//        assertTrue(USER3.getPassword().equals(user.getPassword()));
//        assertTrue(USER3.getName().equals(user.getEmail()));
//        assertTrue(USER3.getEmail().equals(user.getName()));
//    }
//
//    @Test(expected = UserNotFoundException.class)
//    public void getNotFound() {
//        User user = service.get(777);
//    }
//
//    @Test
//    public void getByEmail() {
//        User user = service.getByEmail(USER2.getEmail());
//        assertEquals(USER2.getEmail(), user.getEmail());
//    }
//
//    @Test(expected = UserNotFoundException.class)
//    public void getByEmailNotFound() {
//        User user = service.getByEmail("xxxx@mail.ru");
//    }
//
//    @Test
//    public void delete() {
//
//        service.delete(USER3_ID);
//
//        List<User> users = service.findAll();
//
//        assertTrue.
//
//    }


}
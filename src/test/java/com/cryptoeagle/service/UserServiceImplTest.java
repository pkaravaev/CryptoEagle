package com.cryptoeagle.service;

import com.cryptoeagle.TestData;
import com.cryptoeagle.entity.User;
import com.cryptoeagle.exception.UserNotFoundException;
import com.cryptoeagle.service.abst.UserService;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.cryptoeagle.TestData.*;
import static org.junit.Assert.*;

public class UserServiceImplTest  extends AbstractTest{

    @Autowired
    UserService service;

    @Test
    public void findAll() {
        List<User> all = service.findAll();
        assertTrue(all.size() == TestData.USERS_COUNT);
    }

    @Test
    public void save() {
        service.saveAndUpdate(USER6);
        List<User> all = service.findAll();
        assertTrue(all.size() == 6);
    }

    @Test
    public void update() {
        service.saveAndUpdate(USER4_UPDATE);
        User user = service.get(USER4_UPDATE.getId());
        assertTrue(user.getEmail().equals(USER4_UPDATE.getEmail()));
        assertTrue(user.getName().equals(USER4_UPDATE.getName()));
        assertTrue(user.getPassword().equals(USER4_UPDATE.getPassword()));
    }

    @Test
    public void get() {
        User user = service.get(USER3.getId());

        assertTrue(USER3.getPassword().equals(user.getPassword()));
        assertTrue(USER3.getName().equals(user.getEmail()));
        assertTrue(USER3.getEmail().equals(user.getName()));
    }

    @Test(expected = UserNotFoundException.class)
    public void getNotFound() {
        User user = service.get(777);
    }

    @Test
    public void getByEmail() {
        User user = service.getByEmail(USER2.getEmail());
        assertEquals(USER2.getEmail(), user.getEmail());
    }

    @Test(expected = UserNotFoundException.class)
    public void getByEmailNotFound() {
        User user = service.getByEmail("xxxx@mail.ru");
    }

    @Test
    public void delete() {
        service.delete(USER4.getId());
        List<User> users = service.findAll();

        boolean result1 =  users.contains(USER1);
        boolean result2 =  users.contains(USER2);
        boolean result3 =  users.contains(USER3);
        boolean result4 =  users.contains(USER5);

        boolean result5 =  users.contains(USER4);
        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
        assertTrue(result4);
        assertFalse(result5);
        assertTrue(users.size() == 4);
    }


}
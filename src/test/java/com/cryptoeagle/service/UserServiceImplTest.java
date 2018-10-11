package com.cryptoeagle.service;


import com.cryptoeagle.AbstractTest;
import com.cryptoeagle.entity.User;
import com.cryptoeagle.exception.UserNotFoundException;
import com.cryptoeagle.service.abst.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class UserServiceImplTest extends AbstractTest {

    private static final int USERS_COUNT = 4;

    private static final int USER1_ID = 100086;
    private static final int USER2_ID = 100089;
    private static final int USER3_ID = 100092;
    private static final int USER4_ID = 100095;

    private static final String USER3_EMAIL = "user3@mail.ru";
    private static final String ERROR_EMAIL = "xxxx@mail.ru";
    private static final int ERROR_ID = 4353563;

    @Autowired
    UserService service;

    @Test
    public void findAll() {
        List<User> all = service.getAll();
        assertTrue(all.size() == USERS_COUNT);
    }

    @Test
    public void save() {
        User user = new User("test_user", "test_email", "test_password");
        service.saveAndUpdate(user);
        List<User> all = service.getAll();
        assertTrue(all.size() == USERS_COUNT + 1);
    }

    @Test
    public void update() {
        User user = new User(USER4_ID, "test_user", "test_email", "$2a$10$X37RA.JpHnr0YsiZuqsFJu3iUtbfyEj3LgP/hFctbeU6yBTVsj8Bu");
        //TODO not work!
        User userFromDb = service.get(USER3_ID);

        userFromDb.setName("test_name");
        userFromDb.setName("test_email");
        userFromDb.setName("$2a$10$X37RA.JpHnr0YsiZuqsFJu3iUtbfyEj3LgP/hFctbeU6yBTVsj8Bu");

        service.saveAndUpdate(user);

        User userFromDbUpdated = service.get(USER3_ID);

        assertTrue(userFromDbUpdated.getEmail().equals("test_email"));
        assertTrue(userFromDbUpdated.getName().equals("test_user"));
        assertTrue(userFromDbUpdated.getPassword().equals("test_password"));

    }

    @Test
    public void get() {
        User user = service.get(USER2_ID);
        assertTrue(user.getPassword().equals(user.getPassword()));
        assertTrue(user.getName().equals("user1"));
        assertTrue(user.getEmail().equals("user1@mail.ru"));
    }

    @Test(expected = UserNotFoundException.class)
    public void getNotFound() {
        User user = service.get(ERROR_ID);
    }

    @Test
    public void getByEmail() {
        User user = service.getByEmail(USER3_EMAIL);
        assertEquals(user.getEmail(), USER3_EMAIL);
    }

    @Test(expected = UserNotFoundException.class)
    public void getByEmailNotFound() {
        User user = service.getByEmail(ERROR_EMAIL);
    }

    @Test
    public void delete() {
        service.delete(USER3_ID);
        List<User> all = service.getAll();
        assertTrue(all.size() == USERS_COUNT - 1);
    }

    @Test(expected = UserNotFoundException.class)
    public void deleteNotFound() {
        service.delete(USER3_ID + 1);
        List<User> all = service.getAll();
    }
}
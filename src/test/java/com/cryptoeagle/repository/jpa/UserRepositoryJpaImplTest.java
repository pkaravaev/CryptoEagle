package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.UserTestData;
import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.repository.AbstractServiceTest;
import com.cryptoeagle.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static com.cryptoeagle.UserTestData.*;
import static org.junit.Assert.assertEquals;



public class UserRepositoryJpaImplTest  extends AbstractServiceTest {

    @Autowired
    UserRepository repository;

    @Test
    public void save() {
        repository.save(appUser1);

    }

    @Test
    public void delete() {
        repository.delete(102);
    }

    @Test
    public void get() {
        AppUser appUser = repository.get(102);
    }

    @Test
    public void getByEmail() {
        AppUser user = repository.getByEmail("vasya@mail.ru");
        assertEquals(user.getId(), USER_ID);
    }

    @Test
    public void getall() {
    }

    @Test
    public void getAllWithBlogs() {
        List<AppUser> getall = repository.getall();
        assertEquals(getall.size(), COUNT_USERS);
    }
}
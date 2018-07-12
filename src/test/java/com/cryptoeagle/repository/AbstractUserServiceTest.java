package com.cryptoeagle.repository;

import com.cryptoeagle.entity.AppUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static com.cryptoeagle.UserTestData.COUNT_USERS;
import static com.cryptoeagle.UserTestData.USER_ID;
import static com.cryptoeagle.UserTestData.appUser1;
import static org.junit.Assert.assertEquals;

@ActiveProfiles( profiles = "dsgdsg")
public class AbstractUserServiceTest extends AbstractServiceTest {

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

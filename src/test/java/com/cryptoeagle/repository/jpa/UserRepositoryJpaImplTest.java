package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.TestData;
import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;


@ContextConfiguration({"classpath:/spring/spring-db.xml",
        "classpath:/spring/spring-app.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryJpaImplTest {

    @Autowired
    UserRepository repository;

    @Test
    public void save() {
        repository.save(TestData.appUser1);
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
    }

    @Test
    public void getall() {
    }

    @Test
    public void getAllWithBlogs() {
        List<AppUser> getall = repository.getall();
    }
}
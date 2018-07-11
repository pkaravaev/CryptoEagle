package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.*;


@ContextConfiguration({"classpath:/spring/spring-db.xml",
        "classpath:/spring/spring-app.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryJpaImplTest {

    @PersistenceContext
    EntityManager entityManager;

    @Test
    public void save() {
        User user = new User();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        System.out.println();
    }

    @Test
    public void delete() {
    }

    @Test
    public void get() {
    }

    @Test
    public void getByEmail() {
    }

    @Test
    public void getall() {
    }

    @Test
    public void getAllWithBlogs() {
    }
}
package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.entity.User;
import com.cryptoeagle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class UserRepositoryJpaImpl implements UserRepository {


    @Autowired
    EntityManager entityManager;

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getall() {
        return null;
    }

    @Override
    public List<User> getAllWithBlogs() {
        return null;
    }
}

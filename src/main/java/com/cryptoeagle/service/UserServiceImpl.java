package com.cryptoeagle.service;

import com.cryptoeagle.entity.User;
import com.cryptoeagle.repository.UserRepository;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll() {
        log.info("get all users");
        return repository.getall();
    }

    @Override
    public void save(User user) {
        log.info("save user");
        repository.save(user);
    }

    @Override
    public User get(int id) {
        log.info("get user id", id);
        return repository.get(id);
    }

    @Override
    public User getByEmail(String email) {
        log.info("get user id", email);
        return repository.getByEmail(email);
    }

    @Override
    public void delete(int id) {
        log.info("delete user by id");
        repository.delete(id);
    }

    @Override
    public void delete(User user) {
        log.info("delete user");
        repository.delete(user.getId());
    }

    @Override
    public User findAmin() {
        log.info("find admin user");
        return repository.getall().stream().filter(e -> e.getAdmin() == true).findFirst().get();
    }


}

package com.cryptoeagle.service;

import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.exception.UserNotFoundException;
import com.cryptoeagle.repository.UserRepository;

import com.cryptoeagle.service.abst.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository repository;

    @Override
    public void deleteAll() {
        log.info("delete all");
        repository.getall();
    }

    @Override
    public List<AppUser> findAll() {
        log.info("get all users");
        return repository.getall();
    }

    @Override
    public void save(AppUser appUser) {
        log.info("save appUser");
        repository.save(appUser);
    }

    @Override
    public AppUser get(int id) {
        log.info("get user id", id);
        return repository.get(id);
    }

    @Override
    public AppUser getByEmail(String email) {
        log.info("get user id", email);
        return repository.getByEmail(email);

    }

    @Override
    public void delete(int id) {
        log.info("delete user by id");
        repository.delete(id);
    }

    @Override
    public void delete(AppUser appUser) {
        log.info("delete appUser");
        repository.delete(appUser.getId());
    }

    @Override
    public AppUser findAmin() {
        log.info("find admin user");
        return repository.getall().stream().filter(e -> e.isAdmin() == true).findFirst().get();
    }

}

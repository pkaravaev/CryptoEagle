package com.cryptoeagle.service;

import com.cryptoeagle.entity.User;
import com.cryptoeagle.exception.UserNotFoundException;
import com.cryptoeagle.repository.UserRepository;

import com.cryptoeagle.service.abst.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository repository;

    @Override
    public void deleteAll() {
        log.info("delete all");
        repository.getall();
    }

    @Override
    public List<User> findAll() {
        log.info("get all users");
        return repository.getall();
    }

    @Override
    public void saveAndUpdate(User user) {
        log.info("save user");
        repository.saveAndUpdate(user);
    }

    @Override
    public User get(int id) {
        log.info("get user id", id);
        return repository.get(id);
    }

    @Override
    public User getByEmail(String email) {
        log.info("get user id", email);
        User user = repository.getByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("User with email " + email + " not found!!!");
        }
        return repository.getByEmail(email);
    }

    @Override
    public void delete(int id) {
        log.info("delete user by id");
        repository.delete(id);
    }

    @Override
    public User getByName(String name) {
        log.info("get by name");
        return repository.getByName(name);
    }

    @Override
    public void delete(User user) {
        log.info("delete user");
        repository.delete(user.getId());
    }

    @Override
    public User findAmin() {
        log.info("find admin user");
        return repository.getall().stream().filter(e -> e.isAdmin() == true).findFirst().get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.getByName(username);

        if(user == null)
            throw new UsernameNotFoundException("User :" + username + " not found!");
        return user;
    }
}

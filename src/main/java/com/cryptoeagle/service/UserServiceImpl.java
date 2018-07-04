package com.cryptoeagle.service;

import com.cryptoeagle.entity.User;
import com.cryptoeagle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll() {
      return   repository.getall();
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public User findAmin() {
        return null;
    }
}

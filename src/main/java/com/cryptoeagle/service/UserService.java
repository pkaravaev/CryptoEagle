package com.cryptoeagle.service;

import com.cryptoeagle.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void save(User user);

    void delete(int id);

    void delete(User user);

    User findAmin();
}

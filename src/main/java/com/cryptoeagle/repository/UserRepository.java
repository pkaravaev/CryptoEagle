package com.cryptoeagle.repository;

import com.cryptoeagle.entity.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    void delete(int id);

    User get(int id);

    User getByEmail(String email);

    List<User> getall();

    List<User> getAllWithBlogs();

}



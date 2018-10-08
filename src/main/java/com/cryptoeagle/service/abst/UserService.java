package com.cryptoeagle.service.abst;

import com.cryptoeagle.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void saveAndUpdate(User user);

    User get(int id);

    User getByEmail(String email);

    User getByName(String name);

    void delete(int id);

    void delete(User user);

    void deleteAll();

}

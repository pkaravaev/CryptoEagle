package com.cryptoeagle.service;

import com.cryptoeagle.entity.AppUser;

import java.util.List;

public interface UserService {

    List<AppUser> findAll();

    void save(AppUser appUser);

    AppUser get(int id);

    AppUser getByEmail(String email);

    void delete(int id);

    void delete(AppUser appUser);

    AppUser findAmin();
}

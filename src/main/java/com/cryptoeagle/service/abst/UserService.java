package com.cryptoeagle.service.abst;

import com.cryptoeagle.entity.AppUser;

import java.util.List;

public interface UserService {

    List<AppUser> findAll();

    void saveAndUpdate(AppUser appUser);

    AppUser get(int id);

    AppUser getByEmail(String email);

    void delete(int id);

    void delete(AppUser appUser);

    void deleteAll();

    AppUser findAmin();
}

package com.cryptoeagle.repository;

import com.cryptoeagle.entity.AppUser;

import java.util.List;

public interface UserRepository {

    AppUser save(AppUser appUser);

    void delete(int id);

    AppUser get(int id);

    AppUser getByEmail(String email);

    List<AppUser> getall();

    List<AppUser> getAllWithBlogs();

}



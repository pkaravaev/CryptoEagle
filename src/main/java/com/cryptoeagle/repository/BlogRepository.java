package com.cryptoeagle.repository;

import com.cryptoeagle.entity.Blog;


import java.util.List;

public interface BlogRepository {

    Blog save(Blog user);

    void delete(int id);

    Blog get(int id);

    List<Blog> getall();
}

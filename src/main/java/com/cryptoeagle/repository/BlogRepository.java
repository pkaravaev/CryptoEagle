package com.cryptoeagle.repository;

import com.cryptoeagle.entity.Blog;


import java.util.List;

public interface BlogRepository {

    Blog save(Blog blog );

    void delete(Blog blog);

    Blog getByName(String name);

    Blog getById(int id);

    List<Blog> getAll();
}

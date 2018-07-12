package com.cryptoeagle.repository;

import com.cryptoeagle.entity.Blog;


import java.util.List;

public interface BlogRepository {

    Blog save(Blog blog, int user );

    void delete(int id, int user);

    Blog get(int id, int user);

    List<Blog> getallByUser( int user);
}

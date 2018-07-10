package com.cryptoeagle.service;

import com.cryptoeagle.entity.Blog;

import java.util.List;

public interface BlogService {

     void save(Blog blog, String username);

     void update(Blog blog,String username);

     List<Blog> findall();
}

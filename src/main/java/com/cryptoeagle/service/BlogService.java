package com.cryptoeagle.service;

import com.cryptoeagle.entity.Blog;

import java.util.List;

public interface BlogService {

     void save(Blog blog, int user_id);

     void update(Blog blog,int user_id);

     List<Blog> findall(int user_id);
}

package com.cryptoeagle.service.abst;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.entity.User;

import java.util.List;

public interface BlogService {

    void save(Blog blog, User user);



    void delete(int blog_int);

    void delete(Blog blog);

    void deleteByName(String name);



    List<Blog> findAllByUser(int user_id);

    List<Blog> getAll();



    Blog getByName(String name);

    public void update();

}

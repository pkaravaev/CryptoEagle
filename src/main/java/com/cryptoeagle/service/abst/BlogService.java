package com.cryptoeagle.service.abst;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;

import java.util.List;

public interface BlogService {

    void save(Blog blog, int user_id);

    void update(Blog blog, int user_id);

    void delete(int blog_int, int user_id);

    void deleteByName(String name);

    List<Blog> findall(int user_id);

    List<Blog> getAll();

    List<Item> itemsFromBlogs(int user_id);

    public void updateFromRss();


}

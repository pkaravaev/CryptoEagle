package com.cryptoeagle.repository;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;

import java.util.List;

public interface ItemRepository {

    void deleteByBlog(String blogName);

    void delete(Item item);

    List<Item> getBySource(String source);

    List<Item> getAll();

    List<String> getSources();

}

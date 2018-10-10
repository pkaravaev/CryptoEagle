package com.cryptoeagle.repository;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;

import java.util.List;

public interface ItemRepository {

    Item save(Item item, int blog_id);

    void saveAll(List<Item> list);

    void delete(int id, int blog_id);

    void deleteAll();

    Item get(int id, int blog_id);

    List<Item> getAll(int blog_id);

    List<Item> getBySource(String source);

    List<Item> getAll();

    List<String> getSources();
}

package com.cryptoeagle.service.abst;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;

import java.util.List;

public interface ItemService {

    void deleteBySource(String blogName);

    void delete(Item item);
    void delete(List<Item> item);

    List<Item> getBySource(String source);

    List<Item> getAll();

    List<String> getSources();

}

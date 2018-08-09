package com.cryptoeagle.service.abst;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;

import java.util.List;

public interface ItemService {

    void saveAndUpdate(Item item);

    void delete(int item);

    Item getByBlog(Blog blog);

    List<Item> getBySource(String source);

    List<Item> getAll();

    List<String> getSources();

}

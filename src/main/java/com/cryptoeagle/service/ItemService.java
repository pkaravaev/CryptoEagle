package com.cryptoeagle.service;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;

import java.util.List;

public interface ItemService {

    List<Item> findall();

    void saveAndUpdate(Item item);

    void delete(int item);

    Item getByBlog(Blog blog);


    

}

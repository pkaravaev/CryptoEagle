package com.cryptoeagle.service;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository repository;
    @Override
    public List<Item> findall() {
        return repository.getall();
    }

    @Override
    public void saveAndUpdate(Item item) {

    }

    @Override
    public void delete(int item) {

    }

    @Override
    public Item getByBlog(Blog blog) {
        return null;
    }
}

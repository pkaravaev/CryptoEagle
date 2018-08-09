package com.cryptoeagle.service;

import com.cryptoeagle.entity.Item;
import com.cryptoeagle.repository.ItemRepository;
import com.cryptoeagle.service.abst.ItemService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class ItemServiceImplTest  extends AbstractTest{

    @Autowired
    ItemService service;

    @Test
    public void findall() {
    }

    @Test
    public void saveAndUpdate() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void getByBlog() {
    }

    @Test
    public void getBySource(){

        List<Item> items = service.getAll();

        assertTrue(items.size() > 0);

    }
}
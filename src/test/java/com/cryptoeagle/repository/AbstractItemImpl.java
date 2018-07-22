package com.cryptoeagle.repository;

import com.cryptoeagle.entity.Item;
import com.cryptoeagle.service.abst.ItemService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AbstractItemImpl extends AbstractTest {

    @Autowired
    ItemService service;

    @Test
    public void findall() {
        List<Item> items = service.findall();
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

}

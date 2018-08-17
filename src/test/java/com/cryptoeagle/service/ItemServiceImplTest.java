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
    ItemServiceImpl service;

    @Test
    public void findall() {
        List<Item> all = service.getAll();
        System.out.println();
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
        List<Item> items = service.getBySource("ccn");
        assertTrue(items.size() > 0);
    }

    @Test
    public void getSources(){
        List<String> items = service.getSources();
        assertTrue(items.size() > 0);
    }

    @Test
    public void update(){
        service.updateItems();;

    }
}
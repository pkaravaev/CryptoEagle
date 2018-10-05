package com.cryptoeagle.rest;


import com.cryptoeagle.entity.Item;
import com.cryptoeagle.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemRestController {

    @Autowired
    private ItemServiceImpl itemService;

    @RequestMapping(value = "/rest/items")
    public List<Item> getItems() {
        return itemService.getAll();
    }

    @RequestMapping(value = "/rest/items/${name}")
    public List<Item> getItemsBySource(@PathVariable String name) {
        return itemService.getBySource(name);
    }
}

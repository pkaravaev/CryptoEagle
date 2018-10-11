package com.cryptoeagle.rest;

import com.cryptoeagle.entity.Item;
import com.cryptoeagle.exception.ItemNotFoundException;
import com.cryptoeagle.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemRestController {

    @Autowired
    private ItemServiceImpl itemService;

    @RequestMapping(value = "/api/news")
    public List<Item> getItems() {
        return itemService.getAll();
    }

    @RequestMapping(value = "/api/news/{name}")
    public List<Item> getItemsBySource(@PathVariable String name) {
        return itemService.getBySource(name);
    }

    @ExceptionHandler(value = ItemNotFoundException.class)
    public ResponseEntity<Object> itemNotFound() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

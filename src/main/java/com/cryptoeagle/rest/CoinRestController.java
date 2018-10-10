package com.cryptoeagle.rest;


import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.repository.CoinRepository;
import com.cryptoeagle.repository.EventRepository;
import com.cryptoeagle.repository.IcoRepository;
import com.cryptoeagle.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoinRestController {

    @Autowired
    private CoinRepository coinRepository;

    @Autowired
    private ItemRepository itemRepository;


    @GetMapping(value = "/api/coins")
    public List<Coin> retrieveAllCoins() {
        return coinRepository.getAllCoins();
    }

    @GetMapping(value = "/api/coins/{symbol}")
    public ResponseEntity<Coin> retrieveCoin(@PathVariable("symbol") String symbol) {
        Coin coin = coinRepository.getBySymbol(symbol);
        ResponseEntity<Coin> entity = new ResponseEntity<>(coin, HttpStatus.OK);
        return entity;
    }

    @GetMapping(value = "/api/news")
    public List<Item> retrieveAllItems() {
        return itemRepository.getAll();
    }

}

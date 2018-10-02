package com.cryptoeagle.rest;


import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.Event;
import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.repository.CoinRepository;
import com.cryptoeagle.repository.EventRepository;
import com.cryptoeagle.repository.IcoRepository;
import com.cryptoeagle.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
public class CoinRestController {

    @Autowired
    private CoinRepository coinRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private IcoRepository icoRepository;

    @GetMapping(value = "/rest/coins", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Coin> retrieveAllCoins() {
        return coinRepository.getAllCoins();
    }

    @GetMapping(value = "/rest/coins/{symbol}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Coin> retrieveCoin(@PathVariable("symbol") String symbol) {
        Coin coin = coinRepository.getBySymbol(symbol);
        ResponseEntity<Coin> entity = new ResponseEntity<>(coin, HttpStatus.OK);
        return entity;
    }

    @GetMapping(value = "/rest/news", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> retrieveAllItems() {
        return itemRepository.getall();
    }

    @GetMapping(value = "/rest/events", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Event> retrieveAllEvents() {
        return eventRepository.getAll();
    }

    @GetMapping(value = "/rest/icos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Ico> retrieveAllIcos() {
        return icoRepository.getAllico();
    }

    @GetMapping(value = "/rest/icos/upcoming", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Ico> retrieveUpcoming() {
        return icoRepository.getUpcomingIco();
    }

    @GetMapping(value = "/rest/icos/finishied", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Ico> retrieveFinished() {
        return icoRepository.getFinishedIco();
    }

    @GetMapping(value = "/rest/icos/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Ico> retrieveActice() {
        return icoRepository.getActiveIco();
    }


}

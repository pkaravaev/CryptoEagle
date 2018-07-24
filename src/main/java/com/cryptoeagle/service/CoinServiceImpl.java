package com.cryptoeagle.service;

import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.PictureCoin;
import com.cryptoeagle.entity.dto.CryptoCoin;
import com.cryptoeagle.repository.CoinRepository;
import com.cryptoeagle.service.abst.CoinService;
import com.cryptoeagle.service.abst.RestClientService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@EnableScheduling
public class CoinServiceImpl implements CoinService {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(CoinServiceImpl.class);

    @Autowired
    CoinRepository repository;

    @Autowired
    RestClientService restClientService;

    public List<Coin> getCoins(String... symbols) {
        log.info("get  coins : ",symbols);
        List<Coin> coinList = new ArrayList<>();
        for (int i = 0; i < symbols.length; i++) {
            Coin coin = getCoin(symbols[i]);
            coinList.add(coin);
        }
        return coinList;
    }

    private Coin getCoin(String symbol) {
        log.info("get  coin :",symbol);
        return repository.getBySymbol(symbol);
    }

    public List<Coin> getTopGainCoins() {
        log.info("get top  coins");
        return repository.getTopGainCoins();
    }

    @Override
    public List<Coin> getTopLoserCoins() {
        log.info("get top losers coins");
        return repository.getTopLoserCoins();
    }

    @Override
    public List<Coin> getAllCoins() {
        log.info("get all coins");
        return repository.getAllCoins();
    }

    @Override
    @Scheduled(fixedDelay = 60000)
    public void updateCoins() {
        System.out.println("update coins : time" + LocalDateTime.now().toString());
        log.info("update coins",LocalDateTime.now());
        repository.deleteAll();
        List<Coin> allCoinsFromProvider = restClientService.getCoins();
        repository.saveCoins(allCoinsFromProvider);
    }

}

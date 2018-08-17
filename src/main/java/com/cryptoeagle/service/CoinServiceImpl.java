package com.cryptoeagle.service;

import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.repository.CoinRepository;
import com.cryptoeagle.service.abst.CoinService;
import com.cryptoeagle.service.abst.RestService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
@EnableScheduling
public class CoinServiceImpl implements CoinService {

    private static final Logger log = Logger.getLogger(CoinServiceImpl.class.getName());

    CoinRepository repository;

    RestService restService;

    @Autowired
    public void CoinServiceImpl(CoinRepository repository, RestService restService) {
        this.repository = repository;
        this.restService = restService;
    }


    public List<Coin> getCoins(String... symbols) {
        log.info("get  coins : " + symbols);
        List<Coin> coinList = new ArrayList<>();
        for (int i = 0; i < symbols.length; i++) {
            Coin coin = getCoin(symbols[i]);
            coinList.add(coin);
        }
        return coinList;
    }


    private Coin getCoin(String symbol) {
        log.info("get  coin  : " + symbol);
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
    @Scheduled(fixedDelay = 600000)
    public void updateCoins() {
        log.info("UPDATE COINS :" + LocalDateTime.now().toString());
        repository.deleteAll();
        List<Coin> allCoinsFromProvider = restService.getCoins();
        repository.saveCoins(allCoinsFromProvider);
    }

}

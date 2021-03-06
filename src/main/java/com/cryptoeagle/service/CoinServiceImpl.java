package com.cryptoeagle.service;

import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.crypto.Chart;
import com.cryptoeagle.exception.CoinNotFoundException;
import com.cryptoeagle.repository.CoinRepository;
import com.cryptoeagle.service.abst.CoinService;
import com.cryptoeagle.service.abst.RestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
@Slf4j
@EnableScheduling
public class CoinServiceImpl implements CoinService {

    CoinRepository repository;

    RestService restService;

    @Autowired
    public void CoinServiceImpl(CoinRepository repository, RestService restService) {
        this.repository = repository;
        this.restService = restService;
    }

    public List<Coin> getCoins(String... symbols) {
        log.info("get  coins : " + symbols);
        return repository.getBySymbols(Arrays.asList(symbols));

    }

    @Override
    public boolean isAvailable(String symbol) {
        log.info("is avalible symbol " + symbol);
        List<Chart> chartCoin = restService.getChartCoin(symbol);
        if (chartCoin.size() > 4)
            return true;
        return false;
    }


    public List<Coin> getTopGainCoins() {
        log.info("get top coins");
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
    public Coin getBySymbol(String symbol) {
        log.info("get  coin  : " + symbol);
        try {
            return repository.getBySymbol(symbol);
        } catch (Exception e) {
            throw new CoinNotFoundException(e.getMessage() + "Coin symbol :" + symbol);
        }
    }


    @Override
    @Transactional
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void save(List<Coin> coins) {
        log.info("save coins");
        for (Coin coin : coins) {
            save(coin);
        }
    }

    @Override
    public void save(Coin coin) {
        log.info("save coin");
        repository.save(coin);

    }

    @Override
//    @Scheduled(fixedRate = 50000)
    @Transactional
    public void updateCoins() {
        log.info("update coins :" + LocalDateTime.now().toString());
        System.out.println("delet all");

        deleteAll();
        List<Coin> allCoinsFromProvider = restService.getCoins();
        allCoinsFromProvider.stream().forEach(e -> e.setDataAvailable(isAvailable(e.getSymbol())));
//        List<Coin> collect = allCoinsFromProvider.stream().limit(10).collect(Collectors.toList());
        save(allCoinsFromProvider);
    }

}

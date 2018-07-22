package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.repository.AbstractTest;
import com.cryptoeagle.repository.CoinRepository;
import com.cryptoeagle.service.abst.CoinService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;


@ActiveProfiles(profiles =  {"Jpa","PostgreSQL"})
public class CoinRepositoryTest extends AbstractTest {

    @Autowired
    CoinService coinService;

    @Autowired
    CoinRepository coinRepository;

    @Test
    public void getById() {
    }

    @Test
    public void getBySymbol() {

        Coin icx = coinRepository.getBySymbol("ICX");

    }

    @Test
    public void saveCoins() {

        List<Coin> coins = coinService.getAllCoins();
//        coinRepository.saveCoins(coins);
    }

    @Test
    public void getAllCoins() {
        List<Coin> allCoins = coinRepository.getAllCoins();

    }

    @Test
    public void getTopGainCoins() {

        List<Coin> topGainCoins = coinRepository.getTopGainCoins();
    }

    @Test
    public void getTopLoserCoins() {
    }
}
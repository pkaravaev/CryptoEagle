package com.cryptoeagle.service;

import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.repository.AbstractTest;
import com.cryptoeagle.service.abst.CoinService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;


@ActiveProfiles(profiles = {"Jpa","PostgreSQL" })
public class CryptoImplTest extends AbstractTest {

    @Autowired
    CoinService coinService;
    @Test
    public void getCoins() {

        List<Coin> gainCoins = coinService.getTopGainCoins();
    }

    @Test
    public void getAllCoins() {
    }

    @Test
    public void getPicCoins() {
    }
}
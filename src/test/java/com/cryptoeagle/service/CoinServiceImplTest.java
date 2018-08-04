package com.cryptoeagle.service;

import com.cryptoeagle.service.abst.CoinService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class CoinServiceImplTest extends AbstractTest{

    @Autowired
    CoinService service;

    @Test
    public void getCoins() {
    }

    @Test
    public void getTopGainCoins() {
    }

    @Test
    public void getTopLoserCoins() {
    }

    @Test
    public void getAllCoins() {
    }

    @Test
    public void updateCoins() {

        service.updateCoins();

    }
}
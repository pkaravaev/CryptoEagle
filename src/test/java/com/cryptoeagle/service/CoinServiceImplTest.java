package com.cryptoeagle.service;

import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.service.abst.CoinService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class CoinServiceImplTest extends AbstractTest{

    @Autowired
    CoinService service;


    @Test
    public void getTopGainCoins() {

        List<Coin> topGainCoins = service.getTopGainCoins();
    }

    @Test
    public void getTopLoserCoins() {

        List<Coin> topLoserCoins = service.getTopLoserCoins();
    }

    @Test
    public void getAllCoins() {
    }

    @Test
    public void updateCoins() {

        service.updateCoins();


    }
    @Test
    public void getCoins() {
    }

    @Test
    public void getCoins1() {
        String[]  symbols = {"BTC","ETH","NEO","EOS","XRP"};
        List<Coin> coins = service.getCoins(symbols);
    }
}
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
        List<Coin> coins = service.getAllCoins();
        assertTrue(coins.size() > 20);
    }

    @Test
    public void updateCoins() {
        service.updateCoins();
    }

    @Test
    public void getCoin() {
        Coin eth = service.getCoin("ETH");
        assertTrue(eth.getSymbol().equals("ETH"));
    }

    @Test
    public void getCoins1() {
        String[]  symbols = {"BTC","ETH","NEO","EOS","XRP"};
        List<Coin> coins = service.getCoins(symbols);
    }

    @Test
    public  void isAvalible(){

        boolean eth = service.isAvailable("ETH");
        boolean xxx = service.isAvailable("XXX");
        boolean btc = service.isAvailable("BTC");
        boolean XRP = service.isAvailable("XRP");
        boolean gdf = service.isAvailable("YYY");
        boolean cvc = service.isAvailable("VVV");

        assertTrue(eth);
        assertTrue(btc);
        assertFalse(xxx);
        assertTrue(XRP);
        assertFalse(cvc);
        assertFalse(gdf);
    }
}
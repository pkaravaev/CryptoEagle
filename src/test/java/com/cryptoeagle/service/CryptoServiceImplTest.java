package com.cryptoeagle.service;

import com.cryptoeagle.entity.CoinC;
import com.cryptoeagle.repository.AbstractServiceTest;
import com.cryptoeagle.service.abst.CryptoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.Assert.*;


@ActiveProfiles(profiles = {"Jpa","PostgreSQL" })
public class CryptoServiceImplTest  extends AbstractServiceTest {

    @Autowired
    CryptoService cryptoService;
    @Test
    public void getCoins() {

        List<CoinC> coins = cryptoService.getAllCoins();

        CoinC c = coins.stream().findFirst().get();

        System.out.println(c.getPercent_change_24h());

        System.out.println();
    }

    @Test
    public void getAllCoins() {
    }

    @Test
    public void getPicCoins() {
    }
}
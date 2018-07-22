package com.cryptoeagle.service;

import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.repository.AbstractServiceTest;
import com.cryptoeagle.service.abst.CryptoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;


@ActiveProfiles(profiles = {"Jpa","PostgreSQL" })
public class CryptoServiceImplTest  extends AbstractServiceTest {

    @Autowired
    CryptoService cryptoService;
    @Test
    public void getCoins() {

        List<Coin> gainCoins = cryptoService.getTopGainCoins();
    }

    @Test
    public void getAllCoins() {
    }

    @Test
    public void getPicCoins() {
    }
}
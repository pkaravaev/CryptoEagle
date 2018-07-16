package com.cryptoeagle.service;

import com.cryptoeagle.entity.dto.CryptoCoin;
import com.cryptoeagle.repository.AbstractServiceTest;
import com.cryptoeagle.service.abst.CryptoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

@ActiveProfiles(profiles = { "Jpa","PostgreSQL" })
public class CryptoServiceImplTest extends AbstractServiceTest {


    @Autowired
    CryptoService cryptoService;

    @Test
    public void getCoins() throws IOException {

        List<CryptoCoin> coins = cryptoService.getCoins();
    }
}
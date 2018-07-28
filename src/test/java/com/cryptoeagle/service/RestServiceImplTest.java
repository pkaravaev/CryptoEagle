package com.cryptoeagle.service;

import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.repository.AbstractTest;
import com.cryptoeagle.service.abst.IcoService;
import com.cryptoeagle.service.abst.RestClientService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;


@ActiveProfiles(profiles = {"Jpa", "PostgreSQL"})
public class RestServiceImplTest extends AbstractTest {


    @Autowired
    RestClientService clientService;

    @Autowired
    IcoService icoService;

    @Test
    public void getIcos() {

      icoService.deletAll();

        for (int i = 0; i < 5; i++) {
            List<Ico> allIcoByPage = clientService.getIcoByPage(i);
            System.out.println("get ico page " +i);
            icoService.saveIcos(allIcoByPage);
        }
    }

    @Test
    public void getUpcomingFromProvider() {
    }

    @Test
    public void getFinishedFromProvider() {
    }

    @Test
    public void getActiveIcoFromProvider() {
    }

    @Test
    public void getCoins() {

        List<Coin> coins = clientService.getCoins();
    }

    @Test
    public void getPicCoins() {
    }

    @Test
    public void getAllCoinsFromProvider() {
    }
}
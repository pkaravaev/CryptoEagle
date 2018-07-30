package com.cryptoeagle.service;

import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.entity.crypto.Idata;
import com.cryptoeagle.repository.AbstractTest;
import com.cryptoeagle.service.abst.IcoService;
import com.cryptoeagle.service.abst.RestClientService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@ActiveProfiles(profiles = {"Jpa", "PostgreSQL"})
public class RestServiceImplTest extends AbstractTest {

    @Autowired
    RestClientService clientService;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    IcoService icoService;

    @Test
    public void getIcos() {

        icoService.deletAll();

        for (int i = 0; i < 2; i++) {
            List<Ico> allIcoByPage = clientService.getIcoByPage(i);
            for(Ico ico : allIcoByPage){

                Idata dataForIco = clientService.getDataForIco(ico.getId());
                ico.setData(dataForIco);
            }
            System.out.println("get ico page " + i);
            icoService.saveIcos(allIcoByPage);
        }
    }

    @Test
    public void getUpcomingFromProvider() {

        List<Ico> upcoming = icoService.getUpcoming();
        List<Ico> finished = icoService.getFinished();
        List<Ico> active = icoService.getActiveIco();

    }

    @Test
    public void getFinishedFromProvider() {
        List<Ico> finished = icoService.getFinished();
    }


    @Test
    public void getActiveIcoFromProvider() {
        List<Ico> active = icoService.getActiveIco();
    }

    @Test
    public void getCoins() {
        Ico ico = icoService.getIcoById(3491);
        Idata data = ico.getData();

    }

    @Test
    public void getPicCoins() {
    }

    @Test
    public void getAllCoinsFromProvider() {
    }
}
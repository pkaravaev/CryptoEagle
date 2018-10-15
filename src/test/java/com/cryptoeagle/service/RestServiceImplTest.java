package com.cryptoeagle.service;

import com.cryptoeagle.AbstractTest;
import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.Event;
import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.entity.PictureCoin;
import com.cryptoeagle.entity.crypto.Chart;
import com.cryptoeagle.entity.crypto.IcoData;
import com.cryptoeagle.service.abst.RestService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;


public class RestServiceImplTest extends AbstractTest {

    private static final int EVENT_COUNT = 10;
    private static final int TOKEN_OAUTH_LENGHT = 86;
    private static final int MINIMAL_CHART_DATA = 5;
    private static final int ICO_BY_PAGE_COUNT = 12;

    private static final int COINS_SIZE = 50;

    @Autowired
    RestServiceImpl service;

    @Test
    public void getEvents() {
        List<Event> events = service.getEvents(EVENT_COUNT);
        assertTrue(events.size() == EVENT_COUNT);
    }

    @Test
    public void getTokenOAUTH() {
        String s = service.getTokenOAUTH();
        assertTrue(s.length() == TOKEN_OAUTH_LENGHT);
    }

    @Test
    public void getChartCoin() {

        List<Chart> ETH = service.getChartCoin("ETH");
        List<Chart> ADA = service.getChartCoin("ADA");
        List<Chart> TRX = service.getChartCoin("TRX");
        List<Chart> IOTA = service.getChartCoin("IOTA");
        List<Chart> BNB = service.getChartCoin("BNB");

        assertTrue(ETH.size() > MINIMAL_CHART_DATA);
        assertTrue(ADA.size() > MINIMAL_CHART_DATA);
        assertTrue(TRX.size() > MINIMAL_CHART_DATA);
        assertTrue(IOTA.size() > MINIMAL_CHART_DATA);
        assertTrue(BNB.size() > MINIMAL_CHART_DATA);
    }

    @Test
    public void getDataForIco() {
        IcoData data = service.getDataForIco(36262);
        assertTrue(data != null);
    }

    @Test
    public void getIcoByPage() {
        //todo don't work on travis

        try {
            List<Ico> icoByPage1 = service.getIcoByPage(1);
            List<Ico> icoByPage5 = service.getIcoByPage(5);
            List<Ico> icoByPage25 = service.getIcoByPage(25);
            assertTrue(icoByPage1.size() == ICO_BY_PAGE_COUNT);
            assertTrue(icoByPage5.size() == ICO_BY_PAGE_COUNT);
            assertTrue(icoByPage25.size() == ICO_BY_PAGE_COUNT);
        }
        catch (Exception e){

        }

    }

    @Test
    public void getCoins() {
        List<Coin> coins = service.getCoins();
        assertTrue(coins.size() > COINS_SIZE);
    }

    @Test
    public void getIcoWithDataByPage() {

        try {
            List<Ico> icos = null;

            for (int i = 0; i < 3; i++) {
                icos = service.getIcoWithDataByPage(i);
            }
            //todo don't work on travis
            assertTrue(icos.size() > 5);
            assertTrue(icos.get(0) != null);
            assertTrue(icos.get(3) != null);
        }catch (Exception e){

        }

    }

    @Test
    public void getPicCoins() {
        List<PictureCoin> picCoins = service.getPicCoins();
        assertTrue(picCoins.size() > 100);
    }


}
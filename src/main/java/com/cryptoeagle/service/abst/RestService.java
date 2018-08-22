package com.cryptoeagle.service.abst;

import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.Event;
import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.entity.crypto.Chart;
import com.cryptoeagle.entity.crypto.Idata;

import java.util.List;

public interface RestService {

    List<Event> getEvents(int count);

    List<Chart> getChartCoin(String symbol);

    List<Coin> getCoins();

    List<Ico> getAllIcosFromIcobench();

    List<Ico> getIcoByPage(int page);

    List<Ico> getIcoWithDataByPage(int page);

    Idata getDataForIco(int id);
}

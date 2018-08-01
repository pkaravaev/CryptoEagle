package com.cryptoeagle;


import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.entity.Coin;
import net.sealake.binance.api.client.BinanceApiClientFactory;
import net.sealake.binance.api.client.BinanceApiRestClient;
import net.sealake.binance.api.client.domain.market.Candlestick;
import net.sealake.binance.api.client.domain.market.CandlestickInterval;
import net.sealake.binance.api.client.impl.BinanceApiRestClientImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

public class test {




    public static void main(String[] args) throws Exception {


        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance("API-KEY", "SECRET");

        BinanceApiRestClient client = factory.newRestClient();


        Long serverTime = client.getServerTime();
        System.out.println(serverTime);

        List<Candlestick> candlesticks = client.getCandlestickBars("EOSBTC", CandlestickInterval.WEEKLY);
        System.out.println(candlesticks);
        System.out.println();


    }

}



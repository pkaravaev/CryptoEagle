package com.cryptoeagle;


import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.Event;
import com.cryptoeagle.entity.WhiteList;
import com.cryptoeagle.entity.crypto.Chart;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import net.sealake.binance.api.client.BinanceApiClientFactory;
import net.sealake.binance.api.client.BinanceApiRestClient;
import net.sealake.binance.api.client.domain.market.Candlestick;
import net.sealake.binance.api.client.domain.market.CandlestickInterval;
import net.sealake.binance.api.client.impl.BinanceApiRestClientImpl;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.apache.http.HttpEntity;
import org.apache.http.RequestLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.web.context.WebApplicationContext;

import javax.rmi.CORBA.Util;
import java.io.InputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class test {


    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void test2(){

        int y= 0;

        for (int x = 0 ; x < 1000000 ; x++)
        {
            y += x;
        }


    }

    public static Chart converter(Candlestick candlestick){

        Chart chart = new Chart();

        long opentime = candlestick.getOpenTime();

        double high = Double.parseDouble(candlestick.getHigh());
        double close = Double.parseDouble(candlestick.getClose());
        double open = Double.parseDouble(candlestick.getOpen());
        double low = Double.parseDouble(candlestick.getLow());

        double[] y = {open, high, low, close};

        chart.setY(y);
        chart.setX(opentime);

        return chart;

    }



    public static void main(String[] args) throws Exception {


        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance();
        BinanceApiRestClient client = factory.newRestClient();

        long s = System.nanoTime();
        long f = System.nanoTime();

        System.out.println(f-s);

        long start = System.currentTimeMillis();
        List<Candlestick> ETH = client.getCandlestickBars("ETHUSDT", CandlestickInterval.DAILY);
        List<Chart> chartList = new ArrayList<>();

         for (int i = 0 ; i < ETH.size() ; i++){
             Candlestick candlestick = ETH.get(i);
             Chart  chart = converter(candlestick);
             chartList.add(chart);
         }

         long finish = System.currentTimeMillis() - start;



        System.out.println(finish);


    }
}



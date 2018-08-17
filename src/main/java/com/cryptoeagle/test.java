package com.cryptoeagle;


import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.Event;
import com.cryptoeagle.entity.WhiteList;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import net.sealake.binance.api.client.BinanceApiClientFactory;
import net.sealake.binance.api.client.BinanceApiRestClient;
import net.sealake.binance.api.client.domain.market.Candlestick;
import net.sealake.binance.api.client.domain.market.CandlestickInterval;
import net.sealake.binance.api.client.impl.BinanceApiRestClientImpl;
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
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.web.context.WebApplicationContext;

import javax.rmi.CORBA.Util;
import java.io.InputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
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



    public static void main(String[] args) throws Exception {

//
//        Document document = Jsoup.connect("https://icodrops.com/whitelist/").get();
//
//        Iterator<Element> iterator = document.select("div.whtico-row").iterator();
//
//        List<WhiteList> whiteLists = new ArrayList<>();
//
//        while (iterator.hasNext()){
//            Element next = iterator.next();
//
//            String status =  next.select("div.whitelist_date").first().childNode(0).toString();
//            String name = next.select("div.whtico-row").first().select("div.white_info").first().childNode(1).childNode(0).childNode(0).toString();
//            String category = next.select("div.whtico-row").first().select("div.white_info").select(".white-ico-category-name").first().childNode(0).toString();
//            String logo = next.select("div.whtico-row").first().select("div.white_ico-icon").get(0).childNode(1).childNode(1).attr("data-src").toString();
//
//            WhiteList whiteList = new WhiteList();
//
//            whiteList.setStatus(status);
//            whiteList.setName(name);
//            whiteList.setLogo(logo);
//            whiteList.setCategory(category);
//
//            whiteLists.add(whiteList);
//        }

         WhiteList whiteList = new WhiteList();

        System.out.println();

    }
}



package com.cryptoeagle;


import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.entity.Coin;
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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.web.context.WebApplicationContext;

import java.io.InputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class test {


    public static void main(String[] args) throws Exception {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("/spring/spring-app.xml", "/spring/spring-mvc.xml", "/spring/spring-db.xml");
        ctx.getEnvironment().setActiveProfiles("Jpa","HSQLDB");
        ctx.refresh();

        System.out.println();


    }
}



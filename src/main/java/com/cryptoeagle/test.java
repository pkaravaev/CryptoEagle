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
import org.springframework.core.env.Environment;
import org.springframework.web.context.WebApplicationContext;

import java.io.InputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class test {

    private static final String CLIENT_ID = "1093_2df42urz78cggks0ggo88sckgkcggo44cog8ocwkco8o4ows8c";
    private static final String CLIENT_SECRET = "3ly2qw9v92io084sgcscow0c8w8gkskcwc0k4wkg4sg8cckcg4";
    private static final String REST_GET_TOKEN = "https://api.coinmarketcal.com/oauth/v2/token";

    public static void main(String[] args) throws Exception {
        LocalDateTime localDateTimeStart = LocalDateTime.of(2018, 8, 10, 01, 00);
        LocalDateTime localDateTimeEnd= LocalDateTime.of(2018, 8, 10, 20, 00);
        Duration between = Duration.between(localDateTimeStart.toLocalTime(), localDateTimeEnd.toLocalTime());
        System.out.println(between.toHours());
    }
}



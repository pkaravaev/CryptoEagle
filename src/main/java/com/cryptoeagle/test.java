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
import java.util.ArrayList;
import java.util.List;

public class test {

    private static final String CLIENT_ID = "1093_2df42urz78cggks0ggo88sckgkcggo44cog8ocwkco8o4ows8c";
    private static final String CLIENT_SECRET = "3ly2qw9v92io084sgcscow0c8w8gkskcwc0k4wkg4sg8cckcg4";
    private static final String REST_GET_TOKEN = "https://api.coinmarketcal.com/oauth/v2/token";

    public static void main(String[] args) throws Exception {

        HttpGet httpGet = new HttpGet(REST_GET_TOKEN + "?grant_type=client_credentials&client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET);
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        InputStream content = entity.getContent();
        List<Character> characterList = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        while (content.available() > 0) {
            char read = (char) content.read();
            builder.append(read);
        }
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(builder.toString());
        String accesToken = node.get("access_token").toString();

        System.out.println(builder);
    }

}



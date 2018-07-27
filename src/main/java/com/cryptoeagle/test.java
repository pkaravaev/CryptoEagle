package com.cryptoeagle;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sealake.binance.api.client.BinanceApiCallback;
import net.sealake.binance.api.client.BinanceApiClientFactory;
import net.sealake.binance.api.client.BinanceApiWebSocketClient;
import net.sealake.binance.api.client.domain.event.AggTradeEvent;
import net.sealake.binance.api.client.domain.market.AggTrade;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.persistence.Persistence;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class test {

    private static String price;


    public static void testApiIcoBench() throws Exception {


        ObjectMapper objectMapper = new ObjectMapper();

        String PRIVATE_KEY = "dca6b42f-115d-4892-8827-08bb79275cef";
        String PUBLIC_KEY = "829d6865-c198-4bcf-9675-5ead3802bb9f";
        String REST_URL = "https://icobench.com/api/v1/icos/all";

        String par ="{ 'page' : 1}";


        String ss = "{\"pages\":\"1\"}";

        JsonNode node2 = objectMapper.readTree(ss);

        String s1 = node2.toString();

        System.out.println(ss);

        byte[] bytes = HmacUtils.hmacSha384(PRIVATE_KEY, par);

        String hmac384sign = Utils.HMAC384sign(PRIVATE_KEY, par);

//        URL url = new URL(REST_URL);
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        Client client = ClientBuilder.newClient();
//        connection.setRequestMethod("POST");
//        connection.setRequestProperty("Content-Type", "application/json");
//        connection.setRequestProperty("Accept", "application/json");
//        connection.setRequestProperty("X-ICObench-Key", PUBLIC_KEY);
//        connection.setRequestProperty("X-ICObench-Sig", "lCH4HxXtwBSQOZXENvUQnnoofGxlRTG30goZz4f+/GN0pDT71RoqyC5U0vpa/8A5");
//        connection.setDoOutput(true);
//        String responseMesagge = connection.getResponseMessage();
//        String s = Utils.readInputStreamToString(connection);
//        JsonNode node = objectMapper.readTree(s);

        HttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost request = new HttpPost(REST_URL);
        StringEntity params = new StringEntity("{ \"page\" : 1}");

        request.addHeader("Content-Type","application/json");
        request.addHeader("Accept","application/json");
        request.addHeader("X-ICObench-Key",PUBLIC_KEY);
        request.addHeader("X-ICObench-Sig",hmac384sign);
        request.setEntity(params);
        HttpResponse response = httpClient.execute(request);

        String s = EntityUtils.toString(response.getEntity());

        System.out.println();
//        Iterator<JsonNode> iterator = node.get("results").iterator();
//        while (iterator.hasNext()) {
//
//            JsonNode next = iterator.next();
//
//            String id = next.get("id").toString();
//            String name = next.get("name").toString();
//            String urlico = next.get("url").toString();
//            String logo = next.get("logo").toString();
//            String desc = next.get("desc").toString();
//            String rating = next.get("rating").toString();
//
//            String preIcoStart;
//            String preIcoEnd;
//            String icoStart;
//            String icoEnd;
//
//            Iterator iterator2 = next.get("dates").iterator();
//
//            while (iterator2.hasNext()) {
//                Object next1 = iterator2.next();
//            }
//
//            System.out.println();
//        }


    }


    public static void main(String[] args) throws Exception {



     testApiIcoBench();


    }

}



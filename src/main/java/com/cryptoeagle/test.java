package com.cryptoeagle;


import com.cryptoeagle.entity.Ico;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class test {

    public static void testApiIcoBench() throws Exception {

        int pages = 1;
        List<Ico> icoList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        String PRIVATE_KEY = "dca6b42f-115d-4892-8827-08bb79275cef";
        String PUBLIC_KEY = "829d6865-c198-4bcf-9675-5ead3802bb9f";
        String REST_URL = "https://icobench.com/api/v1/icos/all";

        for (int i = 0; i < 10; i++) {
            String param = "{\"page\":" + i + "}";
            String hmac384sign = Utils.HMAC384sign(PRIVATE_KEY, param);
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost request = new HttpPost(REST_URL);
            StringEntity paramEN = new StringEntity(param);
            System.out.println(EntityUtils.toString(paramEN));
            request.addHeader("Content-Type", "application/json");
            request.addHeader("Accept", "application/json");
            request.addHeader("X-ICObench-Key", PUBLIC_KEY);
            request.addHeader("X-ICObench-Sig", hmac384sign);
            request.setEntity(paramEN);
            HttpResponse response = httpClient.execute(request);
            String s = EntityUtils.toString(response.getEntity());
            JsonNode node = objectMapper.readTree(s);
            if (pages == 1) {
                pages = Integer.parseInt(node.get("pages").toString());
            }
            Iterator<JsonNode> iterator = node.get("results").iterator();
            while (iterator.hasNext()) {
                JsonNode next = iterator.next();

                String id = next.get("id").toString();
                String name = next.get("name").toString();
                String url = next.get("url").toString();
                String logo = next.get("logo").toString();
                String desc = next.get("desc").toString();
                String rating = next.get("rating").toString();
                String raised = next.get("raised").toString();

                JsonNode node2 = next.get("dates");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");

                String oldPreIcoStart = node2.get("preIcoStart").toString();
                String oldpreIcoEnd = node2.get("preIcoEnd").toString();
                String oldIcoStart = node2.get("icoStart").toString();
                String oldIcoEnd = node2.get("icoEnd").toString();

                LocalDateTime preIcoStart = null;
                try {
                    preIcoStart = LocalDateTime.parse(oldPreIcoStart.substring(1, oldPreIcoStart.length() - 1), formatter);
                } catch (Exception e) {
                }
                LocalDateTime preIcoEnd= null;
                try {
                    preIcoEnd = LocalDateTime.parse(oldpreIcoEnd.substring(1, oldPreIcoStart.length() - 1), formatter);
                } catch (Exception e) {
                }
                LocalDateTime icoStart= null;
                try {
                    icoStart = LocalDateTime.parse(oldIcoStart.substring(1, oldPreIcoStart.length() - 1), formatter);
                } catch (Exception e) {
                }
                LocalDateTime icoEnd= null;
                try {
                    icoEnd = LocalDateTime.parse(oldIcoEnd.substring(1, oldPreIcoStart.length() - 1), formatter);
                } catch (Exception e) {
                }

                Ico ico = new Ico();
                ico.setId(Integer.parseInt(id));
                ico.setName(name);
                ico.setWebsite_link(url);
                ico.setImage(logo);
                ico.setDescription(desc);
                ico.setRating(Double.parseDouble(rating));

                ico.setPreIcoStart(preIcoStart);
                ico.setPreIcoEnd(preIcoEnd);
                ico.setIcoStart(icoStart);
                ico.setIcoEnd(icoEnd);

                icoList.add(ico);

            }
        }

        System.out.println();

    }


    public static void main(String[] args) throws Exception {

        testApiIcoBench();
        System.out.println();

    }

}



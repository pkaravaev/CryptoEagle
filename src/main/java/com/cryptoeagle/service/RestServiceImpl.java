package com.cryptoeagle.service;

import com.cryptoeagle.entity.*;
import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.entity.crypto.Exchange;
import com.cryptoeagle.entity.crypto.Idata;
import com.cryptoeagle.entity.crypto.Team;
import com.cryptoeagle.service.abst.RestService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

@Service
public class RestServiceImpl implements RestService {

    private static final String PRIVATE_KEY = "dca6b42f-115d-4892-8827-08bb79275cef";
    private static final String PUBLIC_KEY = "829d6865-c198-4bcf-9675-5ead3802bb9f";
    private static final String REST_GET_ALL = "https://icobench.com/api/v1/icos/all";
    private static final String REST_GET_DATA = "https://icobench.com/api/v1/ico/";

    @Override
    public List<Ico> getIcos() {
        List<Ico> icoList = new ArrayList<>();
        return icoList;
    }

    private List<Ico> getListIco(String url, String status) {

        ObjectMapper objectMapper = new ObjectMapper();

        Client client = ClientBuilder.newClient();
        String icos = client.target(url)
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        List<Ico> icoList = new ArrayList<>();
        try {

            JsonNode node = objectMapper.readTree(icos);
            JsonNode node1 = node.findParent(status).get(status);

            Iterator<JsonNode> iterator = node1.iterator();

            while (iterator.hasNext()) {

                JsonNode next = iterator.next();
                Ico ico = new Ico();

                ico.setName(" ");
                ico.setDescription(" ");
                ico.setWebsite_link(" ");


                icoList.add(ico);
            }
        } catch (Exception e) {
        }
        return icoList;
    }

    public List<Ico> getAllIcosFromIcobench() {
        int pagesCount = 1;
        List<Ico> icoList = new ArrayList<>();
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println("!");
            for (int i = 0; i < 2; i++) {
                String param = "{\"page\":" + i + "}";
                String s = buildHttpRequest(param, REST_GET_ALL);
                JsonNode node = objectMapper.readTree(buildHttpRequest(param, REST_GET_ALL));
                Iterator<JsonNode> iterator = node.get("results").iterator();

                while (iterator.hasNext()) {
                    JsonNode next = iterator.next();
                    icoList.add(convertJsonToIco(next));
                }
            }


        } catch (Exception e) {
            System.out.println("Ошибка" + e.getMessage());
        }
        return icoList;
    }
    @Override
    public Idata getDataForIco(int id) {

        Idata idata = new Idata();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String sign = HMAC384sign(PRIVATE_KEY, "");
            String url = REST_GET_DATA + id;
            String s = buildHttpRequest("", url);
            JsonNode node = objectMapper.readTree(s);
            return convertJsonToIcoData(node);
        } catch (Exception e) {

        }


        return idata;
    }

    public List<Ico> getIcoByPage(int page) {
        List<Ico> icoList = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println("!");
            String param = "{\"page\":" + page + "}";
            String s = buildHttpRequest(param, REST_GET_ALL);
            JsonNode node = objectMapper.readTree(s);
            Iterator<JsonNode> iterator = node.get("results").iterator();
            while (iterator.hasNext()) {
                JsonNode next = iterator.next();
                Ico ico = convertJsonToIco(next);
                ico.setPage(page);
                icoList.add(ico);
            }
        } catch (Exception e) {
            System.out.println("Ошибка" + e.getMessage());
        }
        return icoList;
    }

    @Override
    public List<Ico> getIcoWithDataByPage(int page) {
        List<Ico> icos = getIcoByPage(page);
        List<Ico> icoswithdata = new ArrayList<>();
        for(Ico ico : icos){
            Idata data = getDataForIco(ico.getId());
            ico.setData(data);
            icoswithdata.add(ico);
        }
        return icoswithdata;
    }




    @Override
    public List<Coin> getCoins() {

        List<PictureCoin> coinspic = this.getPicCoins();

        List<Coin> coins = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        Client client = ClientBuilder.newClient();
        String data = client.target("https://api.coinmarketcap.com/v2/ticker/")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);

        JsonNode node = null;
        try {
            node = objectMapper.readTree(data);

        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode data1 = node.get("data");
        Iterator<JsonNode> iterator = data1.iterator();

        while (iterator.hasNext()) {

            try {
                JsonNode next = iterator.next();
                Coin c = new Coin();
                NumberFormat numberFormat = NumberFormat.getInstance();
                numberFormat.setMaximumIntegerDigits(Integer.MAX_VALUE);
                DecimalFormat df = new DecimalFormat("#");
                df.setMaximumFractionDigits(0);
                String id = next.get("id").toString();
                String name = next.get("name").toString();
                String symbol = next.get("symbol").toString();
                String rank = next.get("rank").toString();
                String circulating_supply = next.get("circulating_supply").toString();
                String price = next.get("quotes").get("USD").get("price").toString();
                String volume_24h = next.get("quotes").get("USD").get("volume_24h").toString();
                String market_cap = next.get("quotes").get("USD").get("market_cap").toString();
                String percent_change_1h = next.get("quotes").get("USD").get("percent_change_1h").toString();
                String percent_change_24h = next.get("quotes").get("USD").get("percent_change_24h").toString();
                String percent_change_7d = next.get("quotes").get("USD").get("percent_change_7d").toString();

                double volume = Double.parseDouble(volume_24h);
                double circul = Double.parseDouble(circulating_supply);
                double market = Double.parseDouble(market_cap);
                double change1 = Double.parseDouble(percent_change_1h);
                double change24 = Double.parseDouble(percent_change_24h);
                double change7 = Double.parseDouble(percent_change_7d);


                String s = numberFormat.format(circul);

                String s1 = s.replaceAll("\\u00A0", "");

                c.setId(Integer.valueOf(id));
                c.setName(name.substring(1, name.length() - 1));
                c.setSymbol(symbol.substring(1, symbol.length() - 1));
                c.setRank(Integer.valueOf(rank));
                c.setPrice(Double.parseDouble(price));

                c.setCirculating_supply(BigDecimal.valueOf(circul));
                c.setPercent_change_24h(change24);
                c.setMarket_cap(BigDecimal.valueOf(market));
                c.setVolume_24h(BigDecimal.valueOf(volume));
                c.setPercent_change_1h(change1);
                c.setPercent_change_24h(change24);
                c.setPercent_change_7d(change7);

                String link = coinspic.stream().filter(e -> e.getSymbol().equals(c.getSymbol())).findFirst().get().getLink();

                c.setImage(link);
                coins.add(c);


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return coins;
    }

    public List<PictureCoin> getPicCoins() {

        List<PictureCoin> coins = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        Client client = ClientBuilder.newClient();
        String data = client.target("https://www.cryptocompare.com/api/data/coinlist/")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);

        JsonNode node = null;
        try {
            node = objectMapper.readTree(data);

        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonNode data1 = node.get("Data");
        Iterator<JsonNode> iterator = data1.iterator();

        while (iterator.hasNext()) {

            try {
                JsonNode next = iterator.next();
                String imageUrl = next.get("ImageUrl").toString();
                String symbol = next.get("Symbol").toString();
                PictureCoin c = new PictureCoin();
                c.setLink("https://www.cryptocompare.com" + imageUrl.substring(1, imageUrl.length() - 1));
                c.setSymbol(symbol.substring(1, symbol.length() - 1));
                coins.add(c);

            } catch (Exception e) {

            }
        }


        return coins;
    }




    private Ico convertJsonToIco(JsonNode jsonNode) {

        String id = jsonNode.get("id").toString();
        String name = deleteCommas(jsonNode.get("name").toString());
        String url = deleteCommas(jsonNode.get("url").toString());
        String logo = deleteCommas(jsonNode.get("logo").toString());

        String desc = deleteCommas(jsonNode.get("desc").toString());
        String rating = jsonNode.get("rating").toString();
        String raised = jsonNode.get("raised").toString();

        JsonNode node2 = jsonNode.get("dates");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");

        String oldPreIcoStart = node2.get("preIcoStart").toString();
        String oldpreIcoEnd = node2.get("preIcoEnd").toString();
        String oldIcoStart = node2.get("icoStart").toString();
        String oldIcoEnd = node2.get("icoEnd").toString();

        LocalDateTime preIcoStart = null;
        try {
            preIcoStart = LocalDateTime.parse(oldPreIcoStart.substring(1, oldPreIcoStart.length() - 1), formatter);
        } catch (Exception e) {

            System.out.println("Ошибка" + e.getMessage());
        }
        LocalDateTime preIcoEnd = null;
        try {
            preIcoEnd = LocalDateTime.parse(oldpreIcoEnd.substring(1, oldPreIcoStart.length() - 1), formatter);
        } catch (Exception e) {
            System.out.println("Ошибка" + e.getMessage());
        }
        LocalDateTime icoStart = null;
        try {
            icoStart = LocalDateTime.parse(oldIcoStart.substring(1, oldPreIcoStart.length() - 1), formatter);
        } catch (Exception e) {
            System.out.println("Ошибка" + e.getMessage());
        }
        LocalDateTime icoEnd = null;
        try {
            icoEnd = LocalDateTime.parse(oldIcoEnd.substring(1, oldPreIcoStart.length() - 1), formatter);
        } catch (Exception e) {
            System.out.println("Ошибка" + e.getMessage());
        }

        Ico ico = new Ico();
        ico.setId(Integer.parseInt(id));
        ico.setName(name);
        ico.setWebsite_link(url);
        ico.setLogolink(logo);
        ico.setDescription(desc);
        ico.setRating(Double.parseDouble(rating));

        ico.setPreIcoStart(preIcoStart);
        ico.setPreIcoEnd(preIcoEnd);
        ico.setIcoStart(icoStart);
        ico.setIcoEnd(icoEnd);

        return ico;
    }

    private Idata convertJsonToIcoData(JsonNode jsonNode) {
        Idata idata = new Idata();

        try {
            JsonNode links = jsonNode.get("links");

            idata.setIntro(deleteCommas(jsonNode.get("intro").toString()).substring(0, 500).concat("..."));


            idata.setLink("twitter", deleteCommas(links.get("twitter").toString()));
            idata.setLink("slack", deleteCommas(links.get("slack").toString()));
            idata.setLink("youtube", deleteCommas(links.get("youtube").toString()));
            idata.setLink("telegram", deleteCommas(links.get("telegram").toString()));
            idata.setLink("www", deleteCommas(links.get("www").toString()));
            idata.setLink("facebook", deleteCommas(links.get("facebook").toString()));
            idata.setLink("medium", deleteCommas(links.get("medium").toString()));
            idata.setLink("github", deleteCommas(links.get("github").toString()));
            idata.setLink("whitepaper", deleteCommas(links.get("whitepaper").toString()));

            JsonNode finance = jsonNode.get("finance");

            idata.setFinance("token", deleteCommas(finance.get("token").toString()));
            idata.setFinance("price", deleteCommas(finance.get("price").toString()));
            idata.setFinance("bonus", deleteCommas(finance.get("bonus").toString()));
            idata.setFinance("tokens", deleteCommas(finance.get("tokens").toString()));
            idata.setFinance("tokentype", deleteCommas(finance.get("tokentype").toString()));
            idata.setFinance("hardcap", deleteCommas(finance.get("hardcap").toString()));
            idata.setFinance("softcap", deleteCommas(finance.get("softcap").toString()));
            idata.setFinance("platform", deleteCommas(finance.get("platform").toString()));
            idata.setFinance("raised", deleteCommas(finance.get("raised").toString()));
            idata.setFinance("accepting", deleteCommas(finance.get("accepting").toString()));

            Iterator<JsonNode> team = jsonNode.get("team").iterator();

            while (team.hasNext()) {

                JsonNode next = team.next();
                Team teammember = new Team();

                teammember.setName(deleteCommas(next.get("name").toString()));
                teammember.setTitle(deleteCommas(next.get("title").toString()));
                teammember.setUrl(deleteCommas(next.get("url").toString()));
                teammember.setLinks(deleteCommas(next.get("links").toString()));
                teammember.setPhoto(deleteCommas(next.get("photo").toString()));
                idata.setCrew(teammember);
            }

            Iterator<JsonNode> echange = jsonNode.get("exchanges").iterator();

            while (echange.hasNext()) {
                JsonNode exchanges = echange.next();

                Exchange exchange = new Exchange();
                exchange.setLogo(deleteCommas(exchanges.get("logo").toString()));
                exchange.setPrice(deleteCommas(exchanges.get("price").toString()));
                exchange.setName(deleteCommas(exchanges.get("name").toString()));
                exchange.setCurrency(deleteCommas(exchanges.get("currency").toString()));
                exchange.setLogo(deleteCommas(exchanges.get("roi").toString()));
                idata.setEchanges(exchange);
            }

            Iterator<JsonNode> iterator2 = jsonNode.get("categories").iterator();

            while (iterator2.hasNext()) {
                JsonNode categories = iterator2.next();
                idata.setCategories("id", deleteCommas(categories.get("id").toString()));
                idata.setCategories("name", deleteCommas(categories.get("name").toString()));
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
            return idata;
        }


        return idata;
    }

    private String buildHttpRequest(String param, String url) {

        String hmac384sign = HMAC384sign(PRIVATE_KEY, param);
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(url);
        String s = "";
        try {
            StringEntity paramEN = new StringEntity(param);
            request.addHeader("Content-Type", "application/json");
            request.addHeader("Accept", "application/json");
            request.addHeader("X-ICObench-Key", PUBLIC_KEY);
            request.addHeader("X-ICObench-Sig", hmac384sign);
            request.setEntity(paramEN);
            HttpResponse response = httpClient.execute(request);
            s = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            System.out.println("Ошибка" + e.getMessage());
        }
        return s;
    }

    private String deleteCommas(String old) {
        if (old.length() > 2)
            return old.substring(1, old.length() - 1);
        else
            return old;
    }

    private String HMAC384sign(String private_key, String data) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(private_key.getBytes(), "HmacSHA384");
            Mac mac = Mac.getInstance("HmacSHA384");
            mac.init(keySpec);
            byte[] bytes = data.getBytes();
            byte[] rawHmac = mac.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(rawHmac);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Ошибка" + e.getMessage());
            return "";
        } catch (InvalidKeyException e) {
            System.out.println("Ошибка" + e.getMessage());
            return "";
        }
    }
}

package com.cryptoeagle.service;

import com.cryptoeagle.Utils;
import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.enumeration.IcoStatus;
import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.entity.PictureCoin;
import com.cryptoeagle.service.abst.RestClientService;
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
public class RestServiceImpl implements RestClientService {

    private static final String PRIVATE_KEY = "dca6b42f-115d-4892-8827-08bb79275cef";
    private static final String PUBLIC_KEY = "829d6865-c198-4bcf-9675-5ead3802bb9f";
    private static final String REST_GET_ALL = "https://icobench.com/api/v1/icos/all";

    @Override
    public List<Ico> getIcos() {

        List<Ico> icoList = new ArrayList<>();

        List<Ico> upcomingFromProvider = getUpcomingFromProvider();
        upcomingFromProvider.stream().forEach(e -> e.setStatus(IcoStatus.UPCOMING));

        List<Ico> activeIcoFromProvider = getActiveIcoFromProvider();
        activeIcoFromProvider.stream().forEach(e -> e.setStatus(IcoStatus.ACTIVE));

        List<Ico> finishedFromProvider = getFinishedFromProvider();
        finishedFromProvider.stream().forEach(e -> e.setStatus(IcoStatus.FINISHED));

        icoList.addAll(upcomingFromProvider);
        icoList.addAll(activeIcoFromProvider);
        icoList.addAll(finishedFromProvider);
        return icoList;
    }

    private List<Ico> getListIco(String rest, String status) {

        ObjectMapper objectMapper = new ObjectMapper();

        Client client = ClientBuilder.newClient();
        String icos = client.target(rest)
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

    public List<Ico> getUpcomingFromProvider() {
        return getListIco("https://api.icowatchlist.com/public/v1/upcoming", "upcoming");
    }

    public List<Ico> getFinishedFromProvider() {
        return getListIco("https://api.icowatchlist.com/public/v1/finished", "finished");
    }

    public List<Ico> getActiveIcoFromProvider() {
        return getListIco("https://api.icowatchlist.com/public/v1/live", "live");
    }


    public List<Ico> getAllIcosFromIcobench() {
        int pagesCount = 1;
        List<Ico> icoList = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            for (int i = 0; i < 10; i++) {
                String param = "{\"page\":" + i + "}";
                JsonNode node = objectMapper.readTree(buildHttpRequest(param, REST_GET_ALL));
                if (pagesCount == 1) {
                    pagesCount = Integer.parseInt(node.get("pages").toString());
                }
                Iterator<JsonNode> iterator = node.get("results").iterator();
                while (iterator.hasNext()) {
                    JsonNode next = iterator.next();
                    icoList.add(convertJsonToIco(next));
                }
            }
        } catch (Exception e) {
        }
        return icoList;
    }


    private String buildHttpRequest(String param, String url) {

        String hmac384sign = HMAC384sign(PRIVATE_KEY, param);
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(url);
        String s = "";
        try {
            StringEntity paramEN = new StringEntity(param);
            System.out.println(EntityUtils.toString(paramEN));
            request.addHeader("Content-Type", "application/json");
            request.addHeader("Accept", "application/json");
            request.addHeader("X-ICObench-Key", PUBLIC_KEY);
            request.addHeader("X-ICObench-Sig", hmac384sign);
            request.setEntity(paramEN);
            HttpResponse response = httpClient.execute(request);
            s = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
        }
        return s;
    }

    private Ico convertJsonToIco(JsonNode jsonNode) {
        String id = jsonNode.get("id").toString();
        String name = jsonNode.get("name").toString();
        String url = jsonNode.get("url").toString();
        String logo = jsonNode.get("logo").toString();
        String desc = jsonNode.get("desc").toString();
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
        }
        LocalDateTime preIcoEnd = null;
        try {
            preIcoEnd = LocalDateTime.parse(oldpreIcoEnd.substring(1, oldPreIcoStart.length() - 1), formatter);
        } catch (Exception e) {
        }
        LocalDateTime icoStart = null;
        try {
            icoStart = LocalDateTime.parse(oldIcoStart.substring(1, oldPreIcoStart.length() - 1), formatter);
        } catch (Exception e) {
        }
        LocalDateTime icoEnd = null;
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

        return ico;
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
            return "";
        } catch (InvalidKeyException e) {
            return "";
        }

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
}

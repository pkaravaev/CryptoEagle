package com.cryptoeagle.service;

import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.PictureCoin;
import com.cryptoeagle.entity.dto.CryptoCoin;
import com.cryptoeagle.service.abst.CryptoService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CryptoServiceImpl implements CryptoService {


    private static final org.slf4j.Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    public List<CryptoCoin> getCoins(String... ids) {
        List<CryptoCoin> coinList = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            Coin coin = getCoin(ids[i]);
            coinList.add(convert(coin));
        }
        return coinList;
    }

    private CryptoCoin convert(Coin coin) {
        return new CryptoCoin(coin.getName(), coin.getSymbol(), coin.getPrice());
    }

    private Coin getCoin(String id_coin) {

        ObjectMapper objectMapper = new ObjectMapper();
        Client client = ClientBuilder.newClient();
        String bitcoin = client.target("https://api.coinmarketcap.com/v2/ticker/" + id_coin + "/")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        Coin coin = null;
        try {
            coin = objectMapper.readValue(bitcoin, Coin.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return coin;
    }

    public List<Coin> getTopGainCoins() {
        return getAllCoins().stream()
                .sorted((o1, o2) -> Double.compare(o2.getPercent_change_24h(),o1.getPercent_change_24h()))
                .limit(10)
                .collect(Collectors.toList());
    }

    @Override
    public List<Coin> getTopLoserCoins() {
        return getAllCoins().stream()
                .sorted((o1, o2) -> Double.compare(o1.getPercent_change_24h(),o2.getPercent_change_24h()))
                .limit(10)
                .collect(Collectors.toList());
    }

    @Override
    public List<Coin> getAllCoins() {

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

                c.setCirculating_supply(circul);
                c.setPercent_change_24h(change24);
                c.setMarket_cap(market);
                c.setVolume_24h(volume);
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

    @Override
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

        log.info("getPitctures count :" + coins.size());


        return coins;
    }


}

package com.cryptoeagle.service;

import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.PictureCoin;
import com.cryptoeagle.entity.dto.CryptoCoin;
import com.cryptoeagle.repository.CoinRepository;
import com.cryptoeagle.service.abst.CoinService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoinServiceImpl implements CoinService {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(CoinServiceImpl.class);

    @Autowired
    CoinRepository repository;

    public List<Coin> getCoins(String... symbols) {
        log.info("get  coins : ",symbols);
        List<Coin> coinList = new ArrayList<>();
        for (int i = 0; i < symbols.length; i++) {
            Coin coin = getCoin(symbols[i]);
            coinList.add(coin);
        }
        return coinList;
    }

    private Coin getCoin(String symbol) {
        log.info("get  coin :",symbol);
        return repository.getBySymbol(symbol);
    }

    public List<Coin> getTopGainCoins() {
        log.info("get top  coins");
        return repository.getTopGainCoins();
    }

    @Override
    public List<Coin> getTopLoserCoins() {
        log.info("get top losers coins");
        return repository.getTopLoserCoins();
    }

    @Override
    public List<Coin> getAllCoins() {
        log.info("get all coins");
        return repository.getAllCoins();
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

    @Override
    @Scheduled(fixedDelay = 5000)
    public void updateCoins() {
        log.info("update coins",LocalDateTime.now());
        List<Coin> allCoinsFromProvider = getAllCoinsFromProvider();
        repository.saveCoins(allCoinsFromProvider);
    }

    @Override
    public List<Coin> getAllCoinsFromProvider() {
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
}

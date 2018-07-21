package com.cryptoeagle.service;

import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.CoinC;
import com.cryptoeagle.entity.dto.CryptoCoin;
import com.cryptoeagle.service.abst.CryptoService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.client.ClientConfig;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CryptoServiceImpl implements CryptoService {


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

    @Override
    public List<CoinC> getAllCoinsFromCC() {


        List<CoinC> coins = new ArrayList<>();

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


        for (int i = 0 ; i < 1000; i++) {

            try {

                JsonNode next = iterator.next();
                String id = next.get("Id").toString();
                String url = next.get("Url").toString();
                String imageUrl = next.get("ImageUrl").toString();
                String name = next.get("Name").toString();
                String symbol = next.get("Symbol").toString();
                String coinName = next.get("CoinName").toString();
                String fullName = next.get("FullName").toString();
                String totalCoinSupply = next.get("TotalCoinSupply").toString();

                CoinC c = new CoinC();
                c.setId(id);
                c.setUrl(url);
                c.setImageUrl(imageUrl);
                c.setName(name);
                c.setSymbol(symbol);
                c.setCoinName(coinName);
                c.setFullName(fullName);
                c.setTotalCoinSupply(totalCoinSupply);

                coins.add(c);
            }
            catch (Exception e){
                System.out.println(i);
            }


        }
        return coins;
    }
}

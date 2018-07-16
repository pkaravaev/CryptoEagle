package com.cryptoeagle.service;

import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.dto.CryptoCoin;
import com.cryptoeagle.service.abst.CryptoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.client.ClientConfig;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CryptoServiceImpl implements CryptoService {


    public List<CryptoCoin> getCoins() {

        ObjectMapper objectMapper = new ObjectMapper();

        Client client = ClientBuilder.newClient();

        String bitcoin = client.target("https://api.coinmarketcap.com/v2/ticker/1/")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);

        String eth = client.target("https://api.coinmarketcap.com/v2/ticker/1027/")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);

        String neo = client.target("https://api.coinmarketcap.com/v2/ticker/1376/")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);


        Coin coin1 = null;
        Coin coin2 = null;
        Coin coin3 = null;

        try {
            coin1 = objectMapper.readValue(bitcoin, Coin.class);
             coin2 = objectMapper.readValue(eth, Coin.class);
             coin3 = objectMapper.readValue(neo, Coin.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<CryptoCoin> coinList = new ArrayList<>();

        coinList.add(convert(coin1));
        coinList.add(convert(coin2));
        coinList.add(convert(coin3));
        return coinList;

    }

    private CryptoCoin convert(Coin coin) {
        return new CryptoCoin(coin.getName(), coin.getSymbol(), coin.getPrice());
    }
}

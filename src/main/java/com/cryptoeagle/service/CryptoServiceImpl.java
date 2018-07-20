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
}

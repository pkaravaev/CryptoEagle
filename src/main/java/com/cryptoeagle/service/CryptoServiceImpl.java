package com.cryptoeagle.service;

import com.cryptoeagle.service.abst.CryptoService;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class CryptoServiceImpl implements CryptoService {


    @Override
    public String getPrice(String name) {

        Client client = ClientBuilder.newClient();

        client.target("https://api.coinmarketcap.com/v2/ticker/1/");

        String dddd = client.target("https://api.coinmarketcap.com/v2/ticker/1/")
                .request()
                .get(String.class);




        return null;
    }
}

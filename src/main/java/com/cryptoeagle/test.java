package com.cryptoeagle;

import com.cryptoeagle.entity.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

public class test {

    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        Client client = ClientBuilder.newClient();

        String res1 = client.target("https://api.coinmarketcap.com/v2/ticker/1/")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);

        String res2 = client.target("https://api.coinmarketcap.com/v2/ticker/1027/")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);

        String res3 = client.target("https://api.coinmarketcap.com/v2/ticker/1376/")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);


        System.out.println(res1);

        Coin coin1 = objectMapper.readValue(res1, Coin.class);
        Coin coin2 = objectMapper.readValue(res2, Coin.class);
        Coin coin3 = objectMapper.readValue(res3, Coin.class);

        System.out.println(coin1.getName() + " цена :" + coin1.getPrice());
        System.out.println(coin2.getName() + " цена :" + coin2.getPrice());
        System.out.println(coin3.getName() + " цена :" + coin3.getPrice());

    }
}



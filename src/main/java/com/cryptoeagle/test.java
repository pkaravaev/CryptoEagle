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

        String bitcoin = client.target("https://api.icowatchlist.com/public/v1/live")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);



        System.out.println(bitcoin);
    }
}



package com.cryptoeagle;


import com.cryptoeagle.entity.ENU.IcoStatus;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import javax.rmi.CORBA.Util;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

public class test {

    public static void main(String[] args) throws Exception {


        ObjectMapper objectMapper = new ObjectMapper();

        String PRIVATE_KEY = "dca6b42f-115d-4892-8827-08bb79275cef";
        String PUBLIC_KEY ="829d6865-c198-4bcf-9675-5ead3802bb9f";
        String REST_URL = "https://icobench.com/api/v1/icos/all";


        String ss = "{\n" +
                "\t\"page\": \"1\"\n" +
                "}";

        System.out.println(ss);

        String hmac384sign = Utils.HMAC384sign(PRIVATE_KEY, "");


        URL url = new URL(REST_URL);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        Client client = ClientBuilder.newClient();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("X-ICObench-Key",PUBLIC_KEY);
        connection.setRequestProperty("X-ICObench-Sig",hmac384sign);


        String s = Utils.readInputStreamToString(connection);

        String responseMesagge = connection.getResponseMessage();

        JsonNode node = objectMapper.readTree(s);

        Iterator<JsonNode> iterator = node.get("results").iterator();

        while (iterator.hasNext()){

            JsonNode next = iterator.next();

            String id = next.get("id").toString();
            String name = next.get("name").toString();
            String urlico = next.get("url").toString();
            String logo = next.get("logo").toString();
            String desc = next.get("desc").toString();
            String rating = next.get("rating").toString();

            String preIcoStart ;
            String preIcoEnd;
            String icoStart;
            String icoEnd;

            Iterator iterator2 = next.get("dates").iterator();

            while (iterator2.hasNext()){

                Object next1 = iterator2.next();

            }

            System.out.println();
        }

        System.out.println();
    }

}



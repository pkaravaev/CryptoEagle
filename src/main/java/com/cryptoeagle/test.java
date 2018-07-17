package com.cryptoeagle;

import com.cryptoeagle.entity.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
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
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.IntConsumer;

public class test {

    public static void main(String[] args) throws IOException {


        ObjectMapper objectMapper = new ObjectMapper();

        Client client = ClientBuilder.newClient();
        String icos = client.target("https://api.icowatchlist.com/public/v1/live")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);

        JsonNode node =  objectMapper.readTree(icos);
        JsonNode node1 = node.findParent("live").get("live");

        Iterator<JsonNode> iterator = node1.iterator();
        List<Ico> icoList = new ArrayList<>();

       while (iterator.hasNext()){
           JsonNode next = iterator.next();
           Ico ico = objectMapper.treeToValue(next, Ico.class);
           icoList.add(ico);
       }

    }
}



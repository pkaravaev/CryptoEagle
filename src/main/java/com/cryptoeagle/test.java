package com.cryptoeagle;

import com.cryptoeagle.entity.coins.Ico;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class test {

    public static void main(String[] args) throws IOException {


        String up = "https://api.icowatchlist.com/public/v1/upcoming";
        String fin = "https://api.icowatchlist.com/public/v1/finished";
        String act = "https://api.icowatchlist.com/public/v1/live";

        ObjectMapper objectMapper = new ObjectMapper();

        Client client = ClientBuilder.newClient();
        String icos = client.target(fin)
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);

        JsonNode node =  objectMapper.readTree(icos);
//        JsonNode node1 = node.findParent("live").get("live");
        JsonNode node1 = node.findParent("active").get("finished");

        Iterator<JsonNode> iterator = node1.iterator();
        List<Ico> icoList = new ArrayList<>();

       while (iterator.hasNext()){
           JsonNode next = iterator.next();
           Ico ico = objectMapper.treeToValue(next, Ico.class);
           icoList.add(ico);
       }

        System.out.println();

    }
}



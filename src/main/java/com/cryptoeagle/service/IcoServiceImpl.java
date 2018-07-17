package com.cryptoeagle.service;

import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.service.abst.IcoService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class IcoServiceImpl implements IcoService {

    @Override
    public List<Ico> getAll() {
        return null;
    }

    @Override
    public List<Ico> getUpcomingIco() {

        ObjectMapper objectMapper = new ObjectMapper();

        Client client = ClientBuilder.newClient();
        String icos = client.target("https://api.icowatchlist.com/public/v1/live")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        List<Ico> icoList = new ArrayList<>();
        try {

            JsonNode node = objectMapper.readTree(icos);
            JsonNode node1 = node.findParent("live").get("live");

            Iterator<JsonNode> iterator = node1.iterator();

            while (iterator.hasNext()) {
                JsonNode next = iterator.next();
                Ico ico = objectMapper.treeToValue(next, Ico.class);
                icoList.add(ico);
            }
        }

        catch (Exception e){ }

        return icoList;
    }

    @Override
    public List<Ico> getFinishedIco() {
        return null;
    }
}

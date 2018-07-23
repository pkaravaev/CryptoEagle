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

    private List<Ico> getListIco(String rest, String status) {

        ObjectMapper objectMapper = new ObjectMapper();

        Client client = ClientBuilder.newClient();
        String icos = client.target(rest)
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        List<Ico> icoList = new ArrayList<>();
        try {

            JsonNode node = objectMapper.readTree(icos);
            JsonNode node1 = node.findParent(status).get(status);

            Iterator<JsonNode> iterator = node1.iterator();

            while (iterator.hasNext()) {
                JsonNode next = iterator.next();
                Ico ico = objectMapper.treeToValue(next, Ico.class);
                icoList.add(ico);
            }
        } catch (Exception e) {
        }
        return icoList;
    }

    @Override
    public List<Ico> getAll() {
        return getListIco("https://api.icowatchlist.com/public/v1/","all");
    }

    @Override
    public List<Ico> getUpcomingIco() {
        return getListIco("https://api.icowatchlist.com/public/v1/upcoming","upcoming");
    }

    @Override
    public List<Ico> getFinishedIco() {
        return getListIco("https://api.icowatchlist.com/public/v1/finished","finished");
    }

    @Override
    public List<Ico> getActiveIco() {
        return getListIco("https://api.icowatchlist.com/public/v1/live","live");
    }
}

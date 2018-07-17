package com.cryptoeagle.service;

import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.service.abst.IcoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
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

        String bitcoin = client.target("https://api.icowatchlist.com/public/v1/live")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);

        System.out.println();


        return null;
    }

    @Override
    public List<Ico> getFinishedIco() {
        return null;
    }
}

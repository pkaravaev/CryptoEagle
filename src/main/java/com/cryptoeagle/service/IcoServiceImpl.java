package com.cryptoeagle.service;

import com.cryptoeagle.entity.ENU.IcoStatus;
import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.repository.IcoRepository;
import com.cryptoeagle.service.abst.IcoService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class IcoServiceImpl implements IcoService {

    @Autowired
    IcoRepository repository;

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


    public List<Ico> getAll() {
       return repository.getAllico();
    }

    @Override
    public List<Ico> getUpcomingFromProvider() {
        return getListIco("https://api.icowatchlist.com/public/v1/upcoming","upcoming");
    }

    @Override
    public List<Ico> getFinishedFromProvider() {
        return getListIco("https://api.icowatchlist.com/public/v1/finished","finished");
    }

    @Override
    public List<Ico> getActiveIcoFromProvider() {
        return getListIco("https://api.icowatchlist.com/public/v1/live","live");
    }

    @Override
    public void updateIcos() {
        List<Ico> allFromProvider = getAllFromProvider();
        saveIcos(allFromProvider);
    }

    @Override
    public List<Ico> getAllFromProvider() {

        List<Ico> icoList = new ArrayList<>();

        List<Ico> upcomingFromProvider = getUpcomingFromProvider();
        upcomingFromProvider.stream().forEach(e -> e.setStatus(IcoStatus.UPCOMING));

        List<Ico> activeIcoFromProvider = getActiveIcoFromProvider();
        activeIcoFromProvider.stream().forEach(e -> e.setStatus(IcoStatus.ACTIVE));

        List<Ico> finishedFromProvider = getFinishedFromProvider();
        finishedFromProvider.stream().forEach(e -> e.setStatus(IcoStatus.FINISHED));

        icoList.addAll(upcomingFromProvider);
        icoList.addAll(activeIcoFromProvider);
        icoList.addAll(finishedFromProvider);

        return icoList;
    }

    @Override
    public void saveIcos(List<Ico> icos) {
              repository.saveIcos(icos);
    }

    @Override
    public List<Ico> getUpcoming() {
        return repository.getUpcomingIco();
    }

    @Override
    public List<Ico> getFinished() {
        return repository.getFinishedIco();
    }

    @Override
    public List<Ico> getActiveIco() {
        return repository.getActiveIco();
    }
}

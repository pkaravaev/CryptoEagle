package com.cryptoeagle.service;

import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.repository.IcoRepository;
import com.cryptoeagle.service.abst.IcoService;
import com.cryptoeagle.service.abst.RestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IcoServiceImpl implements IcoService {

    @Autowired
    IcoRepository repository;

    @Autowired
    RestClientService clientService;

    public List<Ico> getAll() {
       return repository.getAllico();
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

    @Override
    public Ico getIcoById(int id) {
        return repository.getIcoByID(id);
    }

    @Override
    public void updateIcos() {
        repository.deleteAll();
        List<Ico> allFromProvider = clientService.getAllIcosFromIcobench();
        saveIcos(allFromProvider);
    }

    @Override
    public void deletAll() {
        repository.deleteAll();
    }
}

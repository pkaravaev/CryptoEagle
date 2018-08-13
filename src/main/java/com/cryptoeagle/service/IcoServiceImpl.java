package com.cryptoeagle.service;

import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.repository.IcoRepository;
import com.cryptoeagle.service.abst.IcoService;
import com.cryptoeagle.service.abst.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;


@Service
@EnableScheduling
public class IcoServiceImpl implements IcoService {

    private static final Logger log = Logger.getLogger(IcoServiceImpl.class.getName());

    @Autowired
    IcoRepository repository;

    @Autowired
    RestService clientService;

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
    @Transactional()
    public Ico getIcoById(int id) {
        return repository.getIcoByID(id);
    }

    @Override
    public Ico getByName(String name) {
        return repository.getByName(name);
    }

    @Override
    @Scheduled(fixedDelay = 600000)
    public void updateIcos() {
        repository.deleteAll();

        List<Ico> page = clientService.getIcoWithDataByPage(1);
        List<Ico> page1 = clientService.getIcoWithDataByPage(2);
        List<Ico> page2 = clientService.getIcoWithDataByPage(3);

        saveIcos(page);
        saveIcos(page1);
        saveIcos(page2);

        log.info("UPDATE ICOS :" + LocalDateTime.now());
    }

    @Override
    public void deletAll() {
        repository.deleteAll();
    }
}

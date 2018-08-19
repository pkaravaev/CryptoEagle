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

    IcoRepository repository;

    RestService service;

    @Autowired
    public void IcoServiceImpl(IcoRepository repository, RestService service){
        this.repository = repository;
        this.service = service;
    }

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
    @Scheduled(fixedDelay = 600000, initialDelay = 8000)
    public void updateIcos() {
        repository.deleteAll();
        for (int i = 1 ; i < 250; i++){
            List<Ico> page = service.getIcoWithDataByPage(i);
            saveIcos(page);
        }
        log.info("UPDATE ICOS :" + LocalDateTime.now());
    }

    @Override
    public void deletAll() {
        repository.deleteAll();
    }
}

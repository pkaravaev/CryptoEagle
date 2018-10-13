package com.cryptoeagle.service;

import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.exception.IcoNotFoundException;
import com.cryptoeagle.repository.IcoRepository;
import com.cryptoeagle.service.abst.IcoService;
import com.cryptoeagle.service.abst.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
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
    public void IcoServiceImpl(IcoRepository repository, RestService service) {
        this.repository = repository;
        this.service = service;
    }

    public List<Ico> getAll() {
        return repository.getAll();
    }

    @Override
    public void save(List<Ico> icos) {
        try {
            repository.save(icos);
        } catch (Exception e) {
            throw new IcoNotFoundException(e.getMessage() + " ICOs not found" );
        }
    }

    @Override
    public List<Ico> getUpcoming() {

        try {
            return repository.getUpcoming();
        } catch (Exception e) {
            throw new IcoNotFoundException(e.getMessage() + "Upcoming ICO not found" );
        }
    }

    @Override
    public List<Ico> getFinished() {
        try {
            return repository.getFinished();

        } catch (Exception e) {
            throw new IcoNotFoundException(e.getMessage() + "Finished ICO not found" );
        }
    }

    @Override
    public List<Ico> getActive() {
        try {
            return repository.getActive();
        } catch (Exception e) {
            throw new IcoNotFoundException(e.getMessage() + "Active ICO not found" );
        }
    }

    @Override
    @Transactional()
    public Ico getById(int id) {
        try {
            return repository.getById(id);
        } catch (Exception e) {
            throw new IcoNotFoundException(e.getMessage() + " Ico id : " + id);
        }
    }

    @Override
    public Ico getByName(String name) {
        try {
            return repository.getByName(name);
        } catch (Exception e) {

            throw new IcoNotFoundException(e.getMessage() + " Ico name : " + name);
        }
    }

    @Override
    public void update() {
        repository.deleteAll();
        for (int i = 1; i < 2; i++) {
            List<Ico> page = service.getIcoWithDataByPage(i);
            save(page);
        }
        log.info("UPDATE ICOS :" + LocalDateTime.now());
    }

    @Override
    public void deletAll() {
        repository.deleteAll();
    }
}

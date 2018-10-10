package com.cryptoeagle.service;

import com.cryptoeagle.entity.Event;
import com.cryptoeagle.repository.EventRepository;
import com.cryptoeagle.service.abst.EventService;
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
public class EventServiceImpl implements EventService {

    private static final Logger log = Logger.getLogger(EventServiceImpl.class.getName());

    RestService restService;
    EventRepository repository;

    @Autowired
    public void  EventRepositoryImpl(RestService service, EventRepository repository){
        this.restService = service;
        this.repository = repository;
    }

    @Override
    public List<Event> getEvents(int count) {
        return restService.getEvents(count);
    }

    @Override
    public List<Event> getAll() {
        return repository.getAll();
    }

    @Override
//    @Scheduled(fixedDelay = 600000, initialDelay = 7000)
    @Transactional
    public void update() {
        log.info("UPDATE EVENTS :" + LocalDateTime.now());
        repository.deleteAll();
        List<Event> events = restService.getEvents(5);
        repository.saveAll(events);
    }
}

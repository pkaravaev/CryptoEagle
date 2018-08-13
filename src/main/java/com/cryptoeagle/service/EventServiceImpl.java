package com.cryptoeagle.service;

import com.cryptoeagle.entity.Event;
import com.cryptoeagle.repository.EventRepository;
import com.cryptoeagle.service.abst.EventService;
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
public class EventServiceImpl implements EventService {

    private static final Logger log = Logger.getLogger(EventServiceImpl.class.getName());


    @Autowired
    RestService service;

    @Autowired
    EventRepository repository;

    @Override
    public List<Event> getEvents(int count) {
        return service.getEvents(count);
    }

    @Override
    @Scheduled(fixedDelay = 600000)
    @Transactional
    public void update() {
        log.info("UPDATE EVENTS :" + LocalDateTime.now());
        repository.deleteAll();
        List<Event> events = service.getEvents(12);
        repository.saveAll(events);
    }
}

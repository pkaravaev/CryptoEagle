package com.cryptoeagle.service;

import com.cryptoeagle.entity.Event;
import com.cryptoeagle.service.abst.EventService;
import com.cryptoeagle.service.abst.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    RestService service;

    @Override
    public List<Event> getEvents(int count) {
        return service.getEvents(count);
    }
}

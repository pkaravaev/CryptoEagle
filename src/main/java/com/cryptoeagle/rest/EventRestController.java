package com.cryptoeagle.rest;

import com.cryptoeagle.entity.Event;
import com.cryptoeagle.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class EventRestController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping(value = "/rest/events")
    public List<Event> retrieveAllEvents() {
        return eventRepository.getAll();
    }
}

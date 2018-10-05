package com.cryptoeagle.rest;

import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.repository.IcoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class IcoRestController {

    @Autowired
    private IcoRepository icoRepository;


    @GetMapping(value = "/rest/icos")
    public List<Ico> retrieveAllIcos() {
        return icoRepository.getAllico();
    }

    @GetMapping(value = "/rest/icos/upcoming")
    public List<Ico> retrieveUpcoming() {
        return icoRepository.getUpcomingIco();
    }

    @GetMapping(value = "/rest/icos/finishied")
    public List<Ico> retrieveFinished() {
        return icoRepository.getFinishedIco();
    }

    @GetMapping(value = "/rest/icos/active")
    public List<Ico> retrieveActice() {
        return icoRepository.getActiveIco();
    }

}

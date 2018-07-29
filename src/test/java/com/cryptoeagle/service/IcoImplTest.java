package com.cryptoeagle.service;

import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.repository.AbstractTest;
import com.cryptoeagle.service.abst.IcoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@ActiveProfiles(profiles = {"Jpa","PostgreSQL" })
public class IcoImplTest extends AbstractTest {


    @Autowired
    IcoService icoService;
    @Test
    public void getAll() {


        List<Ico> upcoming = icoService.getUpcoming();
    }

    @Test
    public void getUpcomingIco() {
    }

    @Test
    public void getFinishedIco() {
    }

    @Test
    public void getActiveIco() {
    }
}
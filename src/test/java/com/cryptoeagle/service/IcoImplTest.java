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


        long start = System.currentTimeMillis();


        long stop = System.currentTimeMillis();

        long  res = stop - start;

        System.out.println(res);
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
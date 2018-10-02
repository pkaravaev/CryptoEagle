package com.cryptoeagle.service;

import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.service.abst.IcoService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class IcoServiceImplTest extends AbstractTest {

    @Autowired
    IcoService service;

    @Test
    public void getAll() {
        List<Ico> all = service.getAll();
        assertTrue(all.size() > 10);
    }

    @Test
    public void saveIcos() {


    }

    @Test
    public void getUpcoming() {
        List<Ico> upcoming = service.getUpcoming();
        for (Ico ico : upcoming) {
            assertTrue(ico.getIcoStart().isAfter(LocalDateTime.now()));
        }
    }

    @Test
    public void getFinished() {
        List<Ico> finished = service.getFinished();
        for (Ico ico : finished) {
            assertTrue(ico.getIcoEnd().isBefore(LocalDateTime.now()));
        }
    }

    @Test
    public void getActiveIco() {
        List<Ico> active = service.getActiveIco();
        for (Ico ico : active) {
            assertTrue(ico.getIcoEnd().isAfter(LocalDateTime.now()));
        }
        List<Ico> collect = service.getActiveIco().stream().limit(6).collect(Collectors.toList());
    }

    @Test
    public void getByName() {
        Ico name = service.getByName("Fanfare");
        Ico ico = service.getByName("Digital Credit");
        assertEquals(name.getName(), "Fanfare");
    }

    @Test
    public void updateIcos() {
        service.updateIcos();
    }

    @Test
    public void deletAll() {
        service.deletAll();
        List<Ico> all = service.getAll();
        assertTrue(all.size() == 0);
    }

}
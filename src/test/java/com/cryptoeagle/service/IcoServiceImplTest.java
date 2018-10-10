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

    private static final int ICO_COUNT = 8;

    private static final LocalDateTime LOCAL_DATE_TIME = LocalDateTime.of(2018,10,8,10,00,00);
    private static final String ICO_NAME = "Zichain";

    @Autowired
    IcoService service;

    @Test
    public void getAll() {
        List<Ico> all = service.getAll();
        assertTrue(all.size() == ICO_COUNT);
    }

    @Test
    public void saveIcos() {

        Ico ico = new Ico();
        ico.setDescription("ico_description");
        ico.setIcoEnd( LocalDateTime.of(2019,10,8,10,00,00));
        ico.setIcoStart( LocalDateTime.of(2018,10,8,10,00,00));
        ico.setPreIcoEnd( LocalDateTime.of(2018,10,8,10,00,00));
        ico.setPreIcoEnd( LocalDateTime.of(2018,10,8,10,00,00));

    }

    @Test
    public void getUpcoming() {
        List<Ico> upcoming = service.getUpcoming();
        for (Ico ico : upcoming) {
            assertTrue(ico.getIcoStart().isAfter(LOCAL_DATE_TIME));
        }
    }

    @Test
    public void getFinished() {
        List<Ico> finished = service.getFinished();
        for (Ico ico : finished) {
            assertTrue(ico.getIcoEnd().isBefore(LOCAL_DATE_TIME));
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

        Ico ico = service.getByName(ICO_NAME);

        assertTrue(ico.getName().equals(ICO_NAME));
        assertTrue(ico.getDescription() != null);
        assertTrue(ico.getLogolink() != null);
        assertTrue(ico.getWebsite_link() != null);
        assertTrue(ico.getName() != null);
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
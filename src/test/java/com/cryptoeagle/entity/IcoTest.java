package com.cryptoeagle.entity;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class IcoTest {

    private static final Ico ICO_UPCOMING_1 = new Ico();
    private static final Ico ICO_ACTIVE_2 = new Ico();
    private static final Ico ICO_FINISH_3 = new Ico();

    private static final String STATUS_UPCOMING = "UPCOMING";

    private static final String STATUS_ACTIVE = "ACTIVE";

    private static final String STATUS_END = "END";


    static {

        ICO_UPCOMING_1.setIcoStart(LocalDateTime.of(2019, 5, 1, 10, 30));
        ICO_UPCOMING_1.setIcoEnd(LocalDateTime.of(2019, 10, 1, 10, 30));

        ICO_ACTIVE_2.setIcoStart(LocalDateTime.of(2018, 7, 1, 10, 30));
        ICO_ACTIVE_2.setIcoEnd(LocalDateTime.of(2019, 5, 1, 10, 30));

        ICO_FINISH_3.setIcoStart(LocalDateTime.of(2018, 3, 1, 10, 30));
        ICO_FINISH_3.setIcoEnd(LocalDateTime.of(2018, 5, 1, 10, 30));

    }

    @Test
    public void todayMinusIcoStart() {
        assertTrue(ICO_UPCOMING_1.todayMinusIcoStart() > 0);

    }

    @Test
    public void todayMinusIcoEnd() {
        assertTrue(ICO_UPCOMING_1.todayMinusIcoEnd() > 0);
    }

    @Test
    public void status() {
        assertTrue(ICO_UPCOMING_1.status().equals(STATUS_UPCOMING));
        assertTrue(ICO_ACTIVE_2.status().equals(STATUS_ACTIVE));
        assertTrue(ICO_FINISH_3.status().equals(STATUS_END));
    }

}
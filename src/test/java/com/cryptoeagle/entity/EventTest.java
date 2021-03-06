package com.cryptoeagle.entity;

import org.junit.Test;

import java.time.ZonedDateTime;

import static org.junit.Assert.*;

public class EventTest {

    private static final Event EVENT = new Event();

    static {

        EVENT.setCoinName("ETH");
        EVENT.setDescription("desc");
        EVENT.setHot(true);
        EVENT.setProof("proof");
        EVENT.setSource("source");
        EVENT.setDate_event(ZonedDateTime.now());
    }

    @Test
    public void diffNowBeetweenDataEventDay() {
        int i = EVENT.diffNowBeetweenDataEventDay();
        assertTrue(EVENT.diffNowBeetweenDataEventDay() == 0);
    }

    @Test
    public void diffNowBeetweenDataEventMinute() {
        assertTrue(EVENT.diffNowBeetweenDataEventMinute() == 0);
    }
}
package com.cryptoeagle.entity;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class ItemTest {


    private static Item ITEM_1 = new Item();
    private static Item ITEM_2 = new Item();

    private static LocalDateTime pointDateTime = LocalDateTime.of(2018,3,10,10,00);


    static {

        ITEM_1.setTitle("item_1_title");
        ITEM_1.setSource("item_1_source");
        ITEM_1.setLink("item_1_link");
        ITEM_1.setPublishDate(LocalDateTime.of(2018,5,10,10,00));

        ITEM_2.setTitle("item_1_title");
        ITEM_2.setSource("item_1_source");
        ITEM_1.setLink("item_1_link");
        ITEM_2.setPublishDate(LocalDateTime.of(2018,7,10,10,00));

    }


    @Test
    public void diffDays() {


        //todo test

        int i = ITEM_1.diffDays();
    }

    @Test
    public void diffMinutes() {
        //todo test

        int i = ITEM_1.diffMinutes();
    }

    @Test
    public void diffHours() {
        //todo test
        int i = ITEM_1.diffHours();

    }
}
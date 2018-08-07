package com.cryptoeagle.service;

import com.cryptoeagle.entity.Item;
import com.cryptoeagle.service.abst.RssService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;



public class RssServiceImplTest extends AbstractTest {

    @Autowired
    RssService rssService;

    @Test
    public void getItems() {
        List<Item> items = rssService.getItems("https://www.coindesk.com/feed/");
        assertTrue(items.size() > 10);
    }
}
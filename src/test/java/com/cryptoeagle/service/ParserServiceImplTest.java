package com.cryptoeagle.service;

import com.cryptoeagle.entity.WhiteList;
import com.cryptoeagle.service.abst.ParserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class ParserServiceImplTest extends AbstractTest {

    @Autowired
    ParserService service;

    @Test
    public void getWhiteList() {
        List<WhiteList> whiteList = service.getWhiteList();
       assertTrue(whiteList.size() > 5);
    }
}
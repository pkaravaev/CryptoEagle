package com.cryptoeagle.service;

import com.cryptoeagle.entity.WhiteList;
import com.cryptoeagle.service.abst.WhiteListService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.AssertTrue;
import java.util.List;

import static org.junit.Assert.*;

public class WhiteListServiceImplTest extends AbstractTest  {

    @Autowired
    WhiteListService service;

    @Test
    public void getWhiteList() {

        List<WhiteList> whiteList = service.getWhiteList();

    }

    @Test
    public void update() {

        service.updateWhitelist();
    }
}
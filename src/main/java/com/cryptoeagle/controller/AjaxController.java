package com.cryptoeagle.controller;

import com.cryptoeagle.entity.dto.CryptoCoin;
import com.cryptoeagle.service.abst.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class AjaxController {


    @Autowired
    CryptoService cryptoService;

    @RequestMapping(value = "/ajax/coins", produces = "application/json")
    @ResponseBody
    public List<CryptoCoin> getPriceCoins() {
        List<CryptoCoin> coins = cryptoService.getCoins();
        return coins;
    }
}

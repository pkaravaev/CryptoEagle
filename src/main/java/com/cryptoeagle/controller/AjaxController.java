package com.cryptoeagle.controller;

import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.dto.CryptoCoin;
import com.cryptoeagle.entity.dto.Quote;
import com.cryptoeagle.service.abst.CoinService;
import com.cryptoeagle.service.abst.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class AjaxController {

    @Autowired
    CoinService coinService;
    @Autowired
    WebSocketService webSocketService;

    @RequestMapping(value = "/ajax/coins", produces = "application/json")
    @ResponseBody
    public List<Coin> getPriceCoins() {
        String[]  symbols = {"BTC","ETH","NEO","EOS","XRP"};
        List<Coin> coins = coinService.getCoins(symbols);
        return coins;
    }

    @RequestMapping(value = "/ajax/price", produces = "application/json")
    @ResponseBody
    public Quote getRealTimePrice() {
        Quote quote = webSocketService.getLasTraderPrice("ethusdt");
        return quote;
    }
}

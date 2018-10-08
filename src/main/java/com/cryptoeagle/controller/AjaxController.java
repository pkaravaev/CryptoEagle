package com.cryptoeagle.controller;

import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.crypto.Chart;
import com.cryptoeagle.entity.dto.Quote;
import com.cryptoeagle.service.abst.CoinService;
import com.cryptoeagle.service.abst.RestService;
import com.cryptoeagle.service.abst.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class AjaxController {

    @Autowired
    CoinService coinService;
    @Autowired
    WebSocketService webSocketService;
    @Autowired
    RestService restService;

    @RequestMapping(value = "/ajax/coins")
    public List<Coin> getPriceCoins() {
        String[]  symbols = {"BTC","ETH","NEO","EOS","XRP"};
        List<Coin> coins = coinService.getCoins(symbols);
        return coins;
    }

    @RequestMapping(value = "/ajax/price" )
    public Quote getRealTimePrice() {
        Quote quote = webSocketService.getLasTraderPrice("ethusdt");
        return quote;
    }

    @RequestMapping(value = "/ajax/coins/{symbol}")
    public List<Chart> getCharts(@PathVariable String symbol) {
        List<Chart> charts = restService.getChartCoin(symbol);
        return charts;
    }

    @RequestMapping(value = "/ajax/topcoins")
    public List<Coin> getGetLooseCoins() {
        List<Coin> topGainCoins = coinService.getTopGainCoins();
        return topGainCoins;
    }

    @RequestMapping(value = "/ajax/loosercoins")
    public List<Coin> getGetTopCoins() {
        List<Coin> topLoserCoins = coinService.getTopLoserCoins();
        return topLoserCoins;
    }
}

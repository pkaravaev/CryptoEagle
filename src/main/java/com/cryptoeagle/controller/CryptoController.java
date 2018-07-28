package com.cryptoeagle.controller;


import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.service.abst.CoinService;
import com.cryptoeagle.service.abst.IcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CryptoController {

    @Autowired
    IcoService icoService;

    @Autowired
    CoinService coinService;

    @RequestMapping("/ico-stats")
    public String icoStats(Model model) {
        List<Ico> icos = icoService.getAll();
        model.addAttribute("icos",icos);
        return "ico-stats";
    }

    @RequestMapping("/ico-list")
    public String icoList(Model model) {



        return "ico-list";
    }

    @RequestMapping("/coin-list")
    public String coinList(Model model) {
        List<Coin> coins = coinService.getAllCoins();
        model.addAttribute("coins", coins);
        return "coin-list";
    }
}

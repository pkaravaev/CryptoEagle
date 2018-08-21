package com.cryptoeagle.controller;


import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.service.abst.CoinService;
import com.cryptoeagle.service.abst.IcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CryptoController {

    @Autowired
    IcoService icoService;

    @Autowired
    CoinService coinService;

    @RequestMapping("/ico-stats")
    public String icoStats(Model model) {
        List<Ico> icos = icoService.getAll();
        model.addAttribute("icos", icos);
        return "ico-stats";
    }

    @RequestMapping("/ico-list")
    public String icoList(Model model) {

        List<Ico> activeIco = icoService.getActiveIco().stream().limit(20).collect(Collectors.toList());
        List<Ico> upcoming = icoService.getUpcoming().stream().limit(20).collect(Collectors.toList());
        List<Ico> finished = icoService.getFinished().stream().limit(20).collect(Collectors.toList());

        model.addAttribute("activeIco", activeIco);
        model.addAttribute("upcoming", upcoming);
        model.addAttribute("finished", finished);

        return "ico-list";
    }

    @RequestMapping("/coin-list")
    public String coinList(Model model) {
        List<Coin> coins = coinService.getAllCoins();
        model.addAttribute("coins", coins);
        return "coin-list";
    }

    @RequestMapping("/ico-page/{name}")
    public String icoPage(@PathVariable String name, Model model) {

        Ico ico = icoService.getByName(name);
        model.addAttribute("ico", ico);

        return "ico-page";
    }

    @RequestMapping("/coin-page")
    public String coinPage(Model model) {

        Coin eth = coinService.getCoin("ETH");

        model.addAttribute("coin", eth);

         return "coin-page";
    }

}

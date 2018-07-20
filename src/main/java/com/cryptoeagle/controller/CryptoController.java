package com.cryptoeagle.controller;


import com.cryptoeagle.entity.Ico;
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

    @RequestMapping("/ico-stats")
    public String icoStats(Model model){

        List<Ico> icos = icoService.getFinishedIco();
        model.addAttribute("icos",icos);
        return "ico-stats";
    }
}

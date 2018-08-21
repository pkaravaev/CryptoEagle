package com.cryptoeagle.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/canvasjschart")
public class CanvasjsChartController {

    @RequestMapping(method = RequestMethod.GET)
    public String springMVC(ModelMap modelMap) {
        return "chart";
    }

}
package com.cryptoeagle.rest;

import com.cryptoeagle.service.abst.CanvasjsChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/restfull-service")
public class CanvasjsChartRestController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    private CanvasjsChartService canvasjsChartService;

    @RequestMapping(value = "/starbucks-corporation-stock-price.json", method = RequestMethod.GET)
    public @ResponseBody
    String getDataPoints(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return canvasjsChartService.getCanvasjsChartData();
    }

}
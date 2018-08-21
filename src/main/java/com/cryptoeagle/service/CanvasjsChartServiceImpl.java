package com.cryptoeagle.service;

import com.cryptoeagle.repository.CanvasjsChartDao;
import com.cryptoeagle.service.abst.CanvasjsChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CanvasjsChartServiceImpl implements CanvasjsChartService {

    @Autowired
    private CanvasjsChartDao canvasjsChartDao;

    public void setCanvasjsChartDao(CanvasjsChartDao canvasjsChartDao) {
        this.canvasjsChartDao = canvasjsChartDao;
    }

    @Override
    public String getCanvasjsChartData() {
        return canvasjsChartDao.getCanvasjsChartData();
    }

}
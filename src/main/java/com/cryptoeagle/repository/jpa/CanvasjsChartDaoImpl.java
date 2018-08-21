package com.cryptoeagle.repository.jpa;


import com.cryptoeagle.entity.CanvasjsChartData;
import com.cryptoeagle.repository.CanvasjsChartDao;
import org.springframework.stereotype.Repository;


@Repository
public class CanvasjsChartDaoImpl implements CanvasjsChartDao {

    @Override
    public String getCanvasjsChartData() {
        return CanvasjsChartData.getCanvasjsDataList();
    }

}
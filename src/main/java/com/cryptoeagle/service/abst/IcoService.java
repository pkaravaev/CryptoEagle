package com.cryptoeagle.service.abst;

import com.cryptoeagle.entity.Ico;

import java.util.List;

public interface IcoService {

    List<Ico> getUpcoming();

    List<Ico> getFinished();

    List<Ico> getActiveIco();

    void updateIcos();

    void saveIcos(List<Ico> icos);

    List<Ico> getAll();

}

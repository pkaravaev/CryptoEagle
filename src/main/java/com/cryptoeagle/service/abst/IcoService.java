package com.cryptoeagle.service.abst;

import com.cryptoeagle.entity.Ico;

import java.util.List;

public interface IcoService {

    List<Ico> getUpcoming();

    List<Ico> getFinished();

    List<Ico> getActiveIco();

    List<Ico> getAll();

    Ico getIcoById(int id);

    Ico getByName(String name);

    void updateIcos();

    void saveIcos(List<Ico> icos);

    void deletAll();

}

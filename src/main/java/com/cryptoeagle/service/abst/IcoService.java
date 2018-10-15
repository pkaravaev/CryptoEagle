package com.cryptoeagle.service.abst;

import com.cryptoeagle.entity.Ico;

import java.util.List;

public interface IcoService {

    List<Ico> getUpcoming();

    List<Ico> getFinished();

    List<Ico> getActive();

    List<Ico> getAll();

    Ico getById(int id);

    Ico getByName(String name);

    void update();

    void save(List<Ico> icos);

    void save(Ico ico);

    void deletAll();

}

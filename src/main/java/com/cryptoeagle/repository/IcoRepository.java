package com.cryptoeagle.repository;

import com.cryptoeagle.entity.Ico;

import java.util.List;

public interface IcoRepository {

    List<Ico> getAll();

    List<Ico> getActive();

    List<Ico> getUpcoming();

    List<Ico> getFinished();


    Ico getById(int id);

    Ico getByName(String name);

    List<Ico> getByNames(List<String> names);


    void deleteAll();
    void save(List<Ico> icos);
}

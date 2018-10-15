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

    void delete(Ico ico);

    void save(Ico ico);
}

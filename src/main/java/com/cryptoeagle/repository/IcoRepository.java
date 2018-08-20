package com.cryptoeagle.repository;

import com.cryptoeagle.entity.Ico;

import java.util.List;

public interface IcoRepository {

    List<Ico> getAllico();

    void saveIcos(List<Ico> icos);

    List<Ico> getActiveIco();

    Ico getIcoByID(int id);

    Ico getByName(String name);

    List<Ico> getByNames(List<String> names);

    List<Ico> getUpcomingIco();

    List<Ico> getFinishedIco();

    void deleteAll();


}

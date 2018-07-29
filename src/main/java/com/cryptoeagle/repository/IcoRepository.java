package com.cryptoeagle.repository;

import com.cryptoeagle.entity.crypto.Ico;

import java.util.List;

public interface IcoRepository {

    List<Ico> getAllico();

    void saveIcos(List<Ico> icos);

    List<Ico> getActiveIco();

    Ico getIcoByID(int id);

    List<Ico> getUpcomingIco();

    List<Ico> getFinishedIco();

    void deleteAll();


}

package com.cryptoeagle.service.abst;

import com.cryptoeagle.entity.Ico;

import java.util.List;

public interface IcoService {

    List<Ico> getUpcomingFromProvider();
    List<Ico> getUpcoming();

    List<Ico> getFinishedFromProvider();
    List<Ico> getFinished();

    List<Ico> getActiveIcoFromProvider();
    List<Ico> getActiveIco();

    List<Ico> getAllFromProvider();

    void updateIcos();

    void saveIcos(List<Ico> icos);

}

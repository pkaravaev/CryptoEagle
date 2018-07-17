package com.cryptoeagle.service.abst;

import com.cryptoeagle.entity.coins.Ico;

import java.util.List;

public interface IcoService {

    List<Ico> getUpcomingIco();

    List<Ico> getFinishedIco();

    List<Ico> getActiveIco();

    List<Ico> getAll();

}

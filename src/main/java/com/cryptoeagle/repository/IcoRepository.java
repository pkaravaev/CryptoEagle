package com.cryptoeagle.repository;

import com.cryptoeagle.entity.Ico;

import java.util.List;

public interface IcoRepository {

    List<Ico> getAllico();

    List<Ico> getAllIcoFromProvider();


}

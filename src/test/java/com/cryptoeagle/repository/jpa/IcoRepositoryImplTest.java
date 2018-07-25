package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.repository.AbstractTest;
import com.cryptoeagle.repository.IcoRepository;
import com.cryptoeagle.service.abst.IcoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.Assert.*;

@ActiveProfiles(profiles =  {"Jpa","PostgreSQL"})
public class IcoRepositoryImplTest extends AbstractTest {


    @Autowired
    IcoRepository repository;

    @Autowired
    IcoService icoService;

    @Test
    public void getAllico() {

        List<Ico> all = icoService.getAll();



        List<Ico> all2 = icoService.getAll();

    }

    @Test
    public void getAllIcoFromProvider() {

        icoService.updateIcos();
    }
}
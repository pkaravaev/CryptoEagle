package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.entity.ENU.IcoStatus;
import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.repository.IcoRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Repository
public class IcoRepositoryImpl implements IcoRepository {


    @PersistenceContext
    EntityManager em;

    @Override
    public List<Ico> getAllico() {
        return null;
    }

    @Override
    @Transactional
    public void saveIcos(List<Ico> icos) {
        for (Ico ico : icos) {
            em.persist(ico);
        }

    }

    @Override
    public List<Ico> getActiveIco() {

        return em.createNamedQuery(Ico.GET_BY_STATUS,Ico.class)
                .setParameter("status",IcoStatus.ACTIVE)
                .getResultList();
    }

    @Override
    public List<Ico> getUpcomingIco() {
        return em.createNamedQuery(Ico.GET_BY_STATUS,Ico.class)
                .setParameter("status",IcoStatus.ACTIVE)
                .getResultList();
    }

    @Override
    public List<Ico> getFinishedIco() {
        return em.createNamedQuery(Ico.GET_BY_STATUS,Ico.class)
                .setParameter("status",IcoStatus.FINISHED)
                .getResultList();
    }
}


package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.entity.crypto.Idata;
import com.cryptoeagle.repository.IcoRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;


@Repository
@Transactional
public class IcoRepositoryJpaImpl implements IcoRepository {

    @PersistenceContext
    EntityManager em;


    @Override
    public List<Ico> getAllico() {
        return em.createNamedQuery(Ico.GET_ALL, Ico.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void saveIcos(List<Ico> icos) {
        for (Ico ico : icos) {
            em.merge(ico);
        }
    }

    @Override
    @Cacheable("activeico")
    public List<Ico> getActiveIco() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return em.createNamedQuery(Ico.GET_ACTIVE, Ico.class)
                .setParameter("date", localDateTime)
                .getResultList();
    }

    @Override
    public List<Ico> getUpcomingIco() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return em.createNamedQuery(Ico.GET_UPCOMING, Ico.class)
                .setParameter("date", localDateTime)
                .getResultList();
    }

    @Override
    public List<Ico> getFinishedIco() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return em.createNamedQuery(Ico.GET_ENDED, Ico.class)
                .setParameter("date", localDateTime)
                .getResultList();
    }

    @Override
    @Transactional
    public void deleteAll() {
        em.createQuery("DELETE FROM Ico ").executeUpdate();
    }

    @Override
    @Transactional
    public Ico getIcoByID(int id) {
        Ico ico = em.createNamedQuery(Ico.GET_BY_ID, Ico.class)
                .setParameter("id", id)
                .getSingleResult();

        ico.getData();

        return ico;
    }

    @Override
    public Ico getByName(String name) {
        return em.createNamedQuery(Ico.GET_BY_NAME, Ico.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}


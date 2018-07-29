package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.entity.crypto.Ico;
import com.cryptoeagle.repository.IcoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class IcoRepositoryImpl implements IcoRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Ico> getAllico() {
        return em.createNamedQuery(Ico.GET_ALL,Ico.class)
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
    public List<Ico> getActiveIco() {
//        return em.createNamedQuery(Ico.GET_BY_STATUS,Ico.class)
//                .setParameter("status",IcoStatus.ACTIVE)
//                .getResultList();
        return null;
    }

    @Override
    public List<Ico> getUpcomingIco() {

//        LocalDateTime localDateTime = LocalDateTime.now().plusMonths(1);
//        return em.createNamedQuery(Ico.GET_ALL,Ico.class)
//                .setParameter("id",100)
//                .getResultList();

        return null;
    }

    @Override
    public List<Ico> getFinishedIco() {
//        return em.createNamedQuery(Ico.GET_BY_STATUS,Ico.class)
//                .setParameter("status",IcoStatus.FINISHED)
//                .getResultList();

        return null;
    }

    @Override
    @Transactional
    public void deleteAll() {
        em.createQuery("DELETE FROM Ico ").executeUpdate();
    }

    @Override
    @Transactional
    public Ico getIcoByID(int id) {
      return   em.createNamedQuery(Ico.GET_BY_ID,Ico.class)
                .setParameter("id",id)
                .getSingleResult();
//
//      return null;
    }
}


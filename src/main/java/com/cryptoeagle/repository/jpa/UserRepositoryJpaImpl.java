package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class UserRepositoryJpaImpl implements UserRepository {


    @PersistenceContext
    EntityManager em;

    @Override
    public AppUser save(AppUser appUser) {
        if (appUser.isNew()) {
            em.persist(appUser);
            return appUser;
        } else {
           return em.merge(appUser);
        }
    }

    @Override
    @Transactional
    public void delete(int id) {

        em.createNamedQuery(AppUser.DELETE)
                .setParameter("id", id)
                .executeUpdate();

    }

    @Override
    public AppUser get(int id) {
        return em.find(AppUser.class, id);
    }

    @Override
    public AppUser getByEmail(String email) {
        return em.createNamedQuery(AppUser.GET_BY_EMAIL, AppUser.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public List<AppUser> getall() {
        return em.createNamedQuery(AppUser.GET_ALL, AppUser.class).getResultList();
    }

    @Override
    public List<AppUser> getAllWithBlogs() {
        return null;
    }
}
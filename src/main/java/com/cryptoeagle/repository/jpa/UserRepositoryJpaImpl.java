package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.exception.UserNotFoundException;
import com.cryptoeagle.repository.UserRepository;
import org.glassfish.jersey.jaxb.internal.XmlJaxbElementProvider;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class UserRepositoryJpaImpl implements UserRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public AppUser saveAndUpdate(AppUser appUser) {
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
        AppUser user;
        try {
            user = (AppUser) em.createNamedQuery(AppUser.GET_BY_ID)
                    .setParameter("id", id)
                    .getSingleResult();
        }catch (Exception e){
            throw new UserNotFoundException("User with id : " + id + " not found!!!");
        }


        return user;
    }

    @Override
    public AppUser getByEmail(String email) {
        AppUser user;
        try {
            user = em.createNamedQuery(AppUser.GET_BY_EMAIL, AppUser.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception ex) {
            throw new UserNotFoundException("User with email : " + email + " not found!!!");
        }
        return user;
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

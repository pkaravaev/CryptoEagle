package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class UserRepositoryJpaImpl implements UserRepository {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public AppUser save(AppUser appUser) {
        if (appUser.isNew()) {
            entityManager.persist(appUser);
            return appUser;
        } else {
           return entityManager.merge(appUser);
        }
    }

    @Override
    @Transactional
    public void delete(int id) {

        entityManager.createNamedQuery(AppUser.DELETE)
                .setParameter("id", id)
                .executeUpdate();

    }

    @Override
    public AppUser get(int id) {
        return entityManager.find(AppUser.class, id);
    }

    @Override
    public AppUser getByEmail(String email) {
        return entityManager.createNamedQuery(AppUser.GET_BY_EMAIL, AppUser.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public List<AppUser> getall() {
        return entityManager.createQuery("SELECT user FROM AppUser user ", AppUser.class).getResultList();
    }

    @Override
    public List<AppUser> getAllWithBlogs() {
        return null;
    }
}

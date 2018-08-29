package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.entity.User;
import com.cryptoeagle.exception.UserNotFoundException;
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
    public User saveAndUpdate(User user) {
        if (user.isNew()) {
            em.persist(user);
            return user;
        } else {
            return em.merge(user);
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        em.createNamedQuery(User.DELETE)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public User get(int id) {
        User user;
        try {
            user = (User) em.createNamedQuery(User.GET_BY_ID)
                    .setParameter("id", id)
                    .getSingleResult();
        }catch (Exception e){
            throw new UserNotFoundException("User with id : " + id + " not found!!!");
        }


        return user;
    }

    @Override
    public User getByEmail(String email) {
        User user;
        try {
            user = em.createNamedQuery(User.GET_BY_EMAIL, User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception ex) {
            throw new UserNotFoundException("User with email : " + email + " not found!!!");
        }
        return user;
    }

    @Override
    public List<User> getall() {
        return em.createNamedQuery(User.GET_ALL, User.class).getResultList();
    }

    @Override
    public List<User> getAllWithBlogs() {
        return null;
    }
}

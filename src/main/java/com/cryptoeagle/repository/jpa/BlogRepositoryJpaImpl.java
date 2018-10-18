package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.entity.User;
import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.repository.BlogRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BlogRepositoryJpaImpl implements BlogRepository {

    @PersistenceContext
    EntityManager em;


    @Override
    public void delete(Blog blog) {
        em.remove(blog);
    }

    @Override
    public Blog getById(int id) {
        return em.createNamedQuery(Blog.GET_BY_ID, Blog.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Blog save(Blog blog) {
        if (blog.isNew()) {
            em.persist(blog);
            return blog;
        } else {
            Blog blogMerge = em.merge(blog);
            em.flush();
            return blogMerge;
        }
    }

    @Override
    public Blog getByName(String name) {
        return em.createNamedQuery(Blog.GET_BY_NAME, Blog.class)
                .setParameter("name", name)
                .getSingleResult();
    }


    @Override
    public List<Blog> getAll() {
        return em.createNamedQuery(Blog.GET_ALL, Blog.class)
                .getResultList();
    }

}

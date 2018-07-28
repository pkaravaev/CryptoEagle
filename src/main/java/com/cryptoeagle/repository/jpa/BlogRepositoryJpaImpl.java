package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.repository.BlogRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class BlogRepositoryJpaImpl implements BlogRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Blog> getallByUser(int user_Id) {
        return em.createNamedQuery(Blog.GET_ALL_BY_USER, Blog.class)
                .setParameter("user_id", user_Id)
                .getResultList();
    }

    @Override
    @Transactional
    public Blog save(Blog blog, int user_id) {

        if (blog.isNew()) {
            AppUser user = em.find(AppUser.class, user_id);
            blog.setAppUser(user);
            em.persist(blog);
            return blog;
        } else {
            return em.merge(blog);
        }
    }

    @Override
    public void delete(int blog_id, int user_id) {
        em.createNamedQuery(Blog.DELETE)
                .setParameter("blog_id", blog_id)
                .setParameter("user_id", user_id)
                .executeUpdate();
    }

    @Override
    public Blog get(int blog_id, int user_id) {
        return  em.createNamedQuery(Blog.GET, Blog.class)
                .setParameter("blog_id", blog_id)
                .setParameter("user_id", user_id)
                .getSingleResult();
    }
}

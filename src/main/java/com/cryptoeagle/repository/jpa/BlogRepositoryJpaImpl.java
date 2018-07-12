package com.cryptoeagle.repository.jpa;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.repository.BlogRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogRepositoryJpaImpl implements BlogRepository {
    @Override
    public Blog save(Blog blog, int user) {
        return null;
    }

    @Override
    public void delete(int id, int user) {

    }

    @Override
    public Blog get(int id, int user) {
        return null;
    }

    @Override
    public List<Blog> getall(int user) {
        return null;
    }
}

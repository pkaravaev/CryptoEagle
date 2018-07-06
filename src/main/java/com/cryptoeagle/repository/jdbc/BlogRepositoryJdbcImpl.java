package com.cryptoeagle.repository.jdbc;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;


@Repository
public class BlogRepositoryJdbcImpl implements BlogRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    private NamedParameterJdbcTemplate namedTemplate;

    @Override
    public Blog save(Blog user) {
        return null;
    }

    @Override
    public void delete(int id) {



    }

    @Override
    public Blog get(int id) {
        return null;
    }

    @Override
    public List<Blog> getall() {
        return null;
    }
}

package com.cryptoeagle.repository.jdbc;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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

    RowMapper<Blog> rowMapper = BeanPropertyRowMapper.newInstance(Blog.class);

    @Autowired
    private NamedParameterJdbcTemplate namedTemplate;

    @Override
    public Blog save(Blog blog) {
        return null;
    }

    @Override

    public void delete(int id) {
         jdbcTemplate.update("DELETE FROM blogs WHERE id_blog = id");
    }

    @Override
    public Blog get(int id) {
       return jdbcTemplate.queryForObject("SELECT * FROM blogs WHERE  id_blog=id", rowMapper);
    }

    @Override
    public List<Blog> getall() {
      return jdbcTemplate.query("SELECT * FROM blogs ", rowMapper);
    }
}

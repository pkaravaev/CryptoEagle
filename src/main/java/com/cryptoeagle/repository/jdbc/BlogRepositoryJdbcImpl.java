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

    private static int id = 1000;

    @Autowired
    private NamedParameterJdbcTemplate namedTemplate;

    @Override
    public Blog save(Blog blog, int user) {
        if (blog.isNew()) {
            jdbcTemplate.update("INSERT INTO blogs (id_blog, name, url, id_user) VALUES (?,?,?,?)", id++, blog.getName(), blog.getUrl(), user);

        } else {
            jdbcTemplate.update("UPDATE blogs SET  id_blog=?, name=?, url=?, id_user=? WHERE id_blog=? ", blog.getId(), blog.getName(), blog.getUrl(), user, blog.getId());
        }
        return blog;
    }

    @Override
    public void delete(int id, int user) {
        jdbcTemplate.update("DELETE FROM blogs WHERE id_blog = ? AND id_user=?", id, user);
    }

    @Override
    public Blog get(int id, int user) {
        return jdbcTemplate.queryForObject("SELECT * FROM blogs WHERE  id_blog=? AND id_user=? ", rowMapper, id, user);
    }

    @Override
    public List<Blog> getallByUser(int user) {
        return jdbcTemplate.query("SELECT * FROM blogs WHERE id_user = ?", rowMapper, user);
    }

}

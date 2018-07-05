package com.cryptoeagle.repository.jdbc;

import com.cryptoeagle.entity.User;
import com.cryptoeagle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;


@Repository
public class UserRepositoryJdbcImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    private NamedParameterJdbcTemplate namedTemplate;

    private RowMapper<User> rowMapper = BeanPropertyRowMapper.newInstance(User.class);

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM users WHERE id=?",id);
    }

    @Override
    public User get(int id) {
        List<User> userList = jdbcTemplate.query("SELECT * FROM users WHERE id=?", rowMapper,id);
        return userList.stream().filter( e -> e.getId() == id).findFirst().get();
    }

    @Override
    public List<User> getall() {
        List<User> userList = jdbcTemplate.query("SELECT * FROM users ", rowMapper);
        return userList;
    }

    @Override
    public List<User> getAllWithBlogs() {
        List<User> userList = jdbcTemplate.query("SELECT * FROM users  INNER JOIN blogs b on users.id_user = b.id_user", rowMapper);
        return userList;
    }
}

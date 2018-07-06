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

    private static int id = 100;

    private RowMapper<User> rowMapper = BeanPropertyRowMapper.newInstance(User.class);

    @Override
    public User save(User user) {

        if (user.isNew()) {
            jdbcTemplate.update("INSERT INTO users (id_user, name, email, password, enable, admin) values (?,?,?,?,?,?)", id++, user.getName(), user.getEmail()
                    , user.getPassword(), user.isEnable(), user.isAdmin());

        } else {
            jdbcTemplate.update("UPDATE users SET id_user = ?, name =?, email = ?, password=?, enable=?,admin = ? WHERE id_user =?", user.getId(), user.getName(), user.getEmail()
                    , user.getPassword(), user.isEnable(), user.isAdmin(), user.getId());
        }

        return user;
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM users WHERE id_user=?", id);
    }

    @Override
    public User get(int id) {
        User user =  jdbcTemplate.queryForObject("SELECT * FROM users WHERE id_user=?", rowMapper, id);
        user.setId(id);
        return user;
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

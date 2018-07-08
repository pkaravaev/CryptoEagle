package com.cryptoeagle.repository.jdbc;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.User;
import com.cryptoeagle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        UserRowMapper userRowMapper = new UserRowMapper();
        User user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE id_user=?", rowMapper, id);
        return user;
    }

    @Override
    public List<User> getall() {

        UserRowMapper userRowMapper = new UserRowMapper();
        List<User> userList = jdbcTemplate.query("SELECT * FROM users ", userRowMapper);
        return userList;
    }

    @Override
    public List<User> getAllWithBlogs() {
        DeeExtractSet deeExtractSet = new DeeExtractSet();
        List<User> userList = jdbcTemplate.query("SELECT * FROM users  INNER JOIN blogs b on users.id_user = b.id_user", deeExtractSet);
        return userList;
    }

    class DeeExtractSet implements ResultSetExtractor<List<User>> {

        @Override
        public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {

            List<User> users = new ArrayList<>();

            User user = new User();

            if (user.isNew()) {

                int user_id = rs.getInt(1);
                String user_name = rs.getString(2);
                String user_email = rs.getString(3);
                String user_password = rs.getString(4);
                boolean user_enable = rs.getBoolean(5);
                boolean user_admin = rs.getBoolean(6);

                int blog_id = rs.getInt(7);
                String blog_name = rs.getString(8);
                String blog_url = rs.getString(9);

                user.setId(user_id);
                user.setName(user_name);
                user.setEmail(user_email);
                user.setPassword(user_password);
                user.setEnable(user_enable);
                user.setAdmin(user_admin);

                Blog blog = new Blog();
                blog.setId(blog_id);
                blog.setName(blog_name);
                blog.setUrl(blog_url);
                blog.setUser(user);


                List<Blog> blogs = user.getBlogs();
                blogs.add(blog);
                user.setBlogs(blogs);

            } else {
                int blog_id = rs.getInt(7);
                String blog_name = rs.getString(8);
                String blog_url = rs.getString(9);
                Blog blog = new Blog();
                blog.setId(blog_id);
                blog.setName(blog_name);
                blog.setUrl(blog_url);
                blog.setUser(user);
                List<Blog> blogs = user.getBlogs();
                blogs.add(blog);
                user.setBlogs(blogs);

            }

            while (rs.next()) {

            }


            return users;
        }

    }

    class UserRowMapper implements RowMapper<User> {


        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            int id_user = rs.getInt("id_user");
            String name = rs.getString("name");
            String password = rs.getString("password");
            boolean enable = rs.getBoolean("enable");
            boolean admin = rs.getBoolean("admin");

            user.setId(id_user);
            user.setName(name);
            user.setPassword(password);
            user.setEnable(enable);
            user.setAdmin(admin);

            return user;

        }
    }
}

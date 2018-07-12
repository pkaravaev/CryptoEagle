package com.cryptoeagle.repository.jdbc;

import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.entity.Blog;
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
import java.sql.ResultSet;
import java.sql.SQLException;
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

    private RowMapper<AppUser> rowMapper = BeanPropertyRowMapper.newInstance(AppUser.class);

    @Override
    public AppUser save(AppUser appUser) {

        if (appUser.isNew()) {
            jdbcTemplate.update("INSERT INTO users (id_user, name, email, password, enable, admin) values (?,?,?,?,?,?)", id++, appUser.getName(), appUser.getEmail()
                    , appUser.getPassword(), appUser.isEnable(), appUser.isAdmin());
        } else {
            jdbcTemplate.update("UPDATE users SET id_user = ?, name =?, email = ?, password=?, enable=?,admin = ? WHERE id_user =?", appUser.getId(), appUser.getName(), appUser.getEmail()
                    , appUser.getPassword(), appUser.isEnable(), appUser.isAdmin(), appUser.getId());
        }
        return appUser;
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM users WHERE id_user=?", id);
    }

    @Override
    public AppUser get(int id) {
        UserRowMapper userRowMapper = new UserRowMapper();
        AppUser appUser = jdbcTemplate.queryForObject("SELECT * FROM users WHERE id_user=?", rowMapper, id);
        return appUser;
    }

    @Override
    public AppUser getByEmail(String email) {
        UserRowMapper userRowMapper = new UserRowMapper();
        AppUser appUser = jdbcTemplate.queryForObject("SELECT * FROM users WHERE email=?", rowMapper, email);
        return appUser;
    }

    @Override
    public List<AppUser> getall() {
        UserRowMapper userRowMapper = new UserRowMapper();
        List<AppUser> appUserList = jdbcTemplate.query("SELECT * FROM users ", userRowMapper);
        return appUserList;
    }

    @Override
    public List<AppUser> getAllWithBlogs() {
        DeeExtractSet deeExtractSet = new DeeExtractSet();
        List<AppUser> appUserList = jdbcTemplate.query("SELECT * FROM users  INNER JOIN blogs b on users.id_user = b.id_user", deeExtractSet);
        return appUserList;
    }

    class DeeExtractSet implements ResultSetExtractor<List<AppUser>> {
        @Override
        public List<AppUser> extractData(ResultSet rs) throws SQLException, DataAccessException {

            List<AppUser> appUsers = new ArrayList<>();

            AppUser appUser = new AppUser();

            if (appUser.isNew()) {

                int user_id = rs.getInt(1);
                String user_name = rs.getString(2);
                String user_email = rs.getString(3);
                String user_password = rs.getString(4);
                boolean user_enable = rs.getBoolean(5);
                boolean user_admin = rs.getBoolean(6);

                int blog_id = rs.getInt(7);
                String blog_name = rs.getString(8);
                String blog_url = rs.getString(9);

                appUser.setId(user_id);
                appUser.setName(user_name);
                appUser.setEmail(user_email);
                appUser.setPassword(user_password);
                appUser.setEnable(user_enable);
                appUser.setAdmin(user_admin);

                Blog blog = new Blog();
                blog.setId(blog_id);
                blog.setName(blog_name);
                blog.setUrl(blog_url);
                blog.setAppUser(appUser);


                List<Blog> blogs = appUser.getBlogs();
                blogs.add(blog);
                appUser.setBlogs(blogs);

            } else {
                int blog_id = rs.getInt(7);
                String blog_name = rs.getString(8);
                String blog_url = rs.getString(9);
                Blog blog = new Blog();
                blog.setId(blog_id);
                blog.setName(blog_name);
                blog.setUrl(blog_url);
                blog.setAppUser(appUser);
                List<Blog> blogs = appUser.getBlogs();
                blogs.add(blog);
                appUser.setBlogs(blogs);

            }

            while (rs.next()) {

            }


            return appUsers;
        }

    }

    class UserRowMapper implements RowMapper<AppUser> {
        @Override
        public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
            AppUser appUser = new AppUser();
            int id_user = rs.getInt("id_user");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String password = rs.getString("password");
            boolean enable = rs.getBoolean("enable");
            boolean admin = rs.getBoolean("admin");

            appUser.setId(id_user);
            appUser.setName(name);
            appUser.setEmail(email);
            appUser.setPassword(password);
            appUser.setEnable(enable);
            appUser.setAdmin(admin);

            return appUser;

        }
    }
}

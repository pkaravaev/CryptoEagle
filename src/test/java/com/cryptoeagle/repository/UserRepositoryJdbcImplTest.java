package com.cryptoeagle.repository;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.User;
import com.cryptoeagle.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@ContextConfiguration({"classpath:/spring/spring-db.xml",
        "classpath:/spring/spring-app.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = {"classpath:db/initdb.sql", "classpath:/db/populate.sql"})

public class UserRepositoryJdbcImplTest {

    @Autowired
    UserRepository repository;

    @Autowired
    UserService service;

    @Autowired
    DataSource dataSource;

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void save() {

        try {
            Connection connection = dataSource.getConnection();

            Statement statement = connection.createStatement();

            boolean execute = statement.execute("SELECT * FROM users INNER JOIN  blogs b on users.id_user = b.id_user");

            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()){

                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                String password = resultSet.getString(4);
                boolean en = resultSet.getBoolean(5);
                boolean ad = resultSet.getBoolean(6);
                int blog_id =  resultSet.getInt(7);
                String name_blog =  resultSet.getString(8);
                String url_blog =  resultSet.getString(9);

                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);
                user.setPassword(password);
                user.setEnable(en);
                user.setAdmin(ad);

                Blog blog = new Blog(blog_id, name_blog, url_blog);

                List<Blog> blogs =new ArrayList<>();
                blogs.add(blog);

                user.setBlogs(blogs);

                System.out.println();




            }
        }
        catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    @Test
    public void delete() {
    }

    @Test
    public void get() {
    }

    @Test
    public void getall() {

        List<User> getall = repository.getall();

        System.out.println();
    }
}
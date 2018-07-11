package com.cryptoeagle;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;
import com.cryptoeagle.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("/spring/spring-app.xml", "/spring/spring-db.xml");

        EntityManagerFactory entityManagerFactory = context.getBean(EntityManagerFactory.class);

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        User user = new User("Vasya","safsf@mail.ru","dsfsdfsdfds",true,true);

        Blog blog1 = new Blog("blog1"," sdfsdfdsf.ru");
        Blog blog2 = new Blog("blog2"," dsgsd.ru");
        Blog blog3 = new Blog("blog3"," sdgdsg.ru");


        Item item1 = new Item("item1","bsfgsdgsdggsgdsg", null,"dffssdfsd@.com");
        Item item2 = new Item("item2","435gdfg6346", null,"dfgdfg@.com");
        Item item3 = new Item("item3","dfgfdf3463", null,"346gf@.com");
        Item item4 = new Item("item4","fdgdf4w5236", null,"dffssdfsd@.com");


//        blog1.setUser(user);
//        blog2.setUser(user);
//        blog3.setUser(user);


//        blog1.setItems(item1);
//        blog1.setItems(item2);
//        item1.setBlog(blog1);
//        item2.setBlog(blog1);
//
//        blog2.setItems(item3);
//        blog2.setItems(item4);
//        item3.setBlog(blog2);
//        item4.setBlog(blog2);


//        user.setBlogs(blog1);
//        user.setBlogs(blog2);
//        user.setBlogs(blog3);
//




        entityManager.getTransaction().begin();

        entityManager.persist(user);

        entityManager.getTransaction().commit();


        System.out.println();
    }
}

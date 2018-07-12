package com.cryptoeagle;

import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class test {

    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("/spring/spring-app.xml", "/spring/spring-db.xml");

        EntityManagerFactory entityManagerFactory = context.getBean(EntityManagerFactory.class);

        EntityManager entityManager = entityManagerFactory.createEntityManager();


        AppUser appUser = new AppUser();
        appUser.setName("Pavel");
        appUser.setEmail("fdfdf.com");
        appUser.setAdmin(true);
        appUser.setPassword("Dfsdfsd");


        Blog blog = new Blog();
        blog.setUrl("dfsfsd.com");
        blog.setName("blog1");

        Item item = new Item();
        item.setDescription("blabalblalbal");
        item.setTitle("title alalala");
        item.setLink("link");
        item.setBlog(blog);

        blog.setItems(item);
        blog.setAppUser(appUser);
        appUser.setBlogs(blog);


        entityManager.getTransaction().begin();

        entityManager.persist(item);

        entityManager.persist(blog);
        entityManager.persist(appUser);


       AppUser  userFromDb = entityManager.find(AppUser.class, 100002);


        entityManager.getTransaction().commit();


        System.out.println();
    }
}

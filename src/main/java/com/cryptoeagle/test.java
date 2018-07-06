package com.cryptoeagle;

import com.cryptoeagle.controller.WelcomeController;
import com.cryptoeagle.entity.User;
import com.cryptoeagle.repository.UserRepository;
import com.cryptoeagle.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.sql.DataSource;
import java.util.List;

public class test {

    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("/spring/spring-app.xml", "/spring/spring-db.xml","/spring/spring-mvc.xml");

        String[] names = context.getBeanDefinitionNames();


        UserService service = context.getBean(UserService.class);

        List<User> all = service.findAll();


        System.out.println();
    }
}

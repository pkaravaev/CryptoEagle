package com.cryptoeagle;

import com.cryptoeagle.entity.Item;
import com.cryptoeagle.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class test {

    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-db.xml", "spring/spring-app.xml");

        String[] names = context.getBeanDefinitionNames();


        DataSource item = context.getBean(DataSource.class);

        UserRepository repository = context.getBean(UserRepository.class);



        System.out.println();
    }
}

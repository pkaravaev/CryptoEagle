package com.cryptoeagle;


import com.cryptoeagle.entity.AppUser;
import com.cryptoeagle.entity.Coin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.context.WebApplicationContext;

public class test {




    public static void main(String[] args) throws Exception {

        ApplicationContext applicationContext = new GenericXmlApplicationContext("/spring/spring-db.xml","/spring/spring-app.xml");

        Environment environment = applicationContext.getEnvironment();

        environment.acceptsProfiles("Jpa","PostgreSQL");


        System.out.println();


    }

}



package com.cryptoeagle;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class test {

    public static void main(String[] args) throws Exception {


        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();

        ConfigurableEnvironment environment = ctx.getEnvironment();

        environment.setActiveProfiles("PostgreSQL","Jpa");

        ctx.load("spring/spring-db.xml","spring/spring-app.xml");

        ctx.refresh();


        System.out.println();
    }

}



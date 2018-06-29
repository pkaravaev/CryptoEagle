package com.cryptoeagle;

import com.cryptoeagle.entity.Item;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-app.xml");

        Item item = context.getBean(Item.class);


        System.out.println();
    }
}

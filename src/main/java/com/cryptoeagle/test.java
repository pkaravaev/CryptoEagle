package com.cryptoeagle;

import com.cryptoeagle.controller.WelcomeController;
import com.cryptoeagle.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.sql.DataSource;

public class test {

    public static void main(String[] args) {


        ApplicationContext context = new FileSystemXmlApplicationContext("C:\\projects\\CryptoEagle\\src\\main\\webapp\\WEB-INF\\spring-app.xml", "C:\\projects\\CryptoEagle\\src\\main\\webapp\\WEB-INF\\spring-mvc.xml","");

        String[] names = context.getBeanDefinitionNames();


        DataSource item = context.getBean(DataSource.class);

        UserRepository repository = context.getBean(UserRepository.class);

        WelcomeController controller = context.getBean(WelcomeController.class);









        System.out.println();
    }
}

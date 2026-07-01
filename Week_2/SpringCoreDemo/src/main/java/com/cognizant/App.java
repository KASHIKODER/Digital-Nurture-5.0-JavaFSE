package com.cognizant;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.cognizant")
public class App {

    public static void main(String[] args) {

        // Spring IoC Container start karo
        ApplicationContext context =
            new AnnotationConfigApplicationContext(App.class);

        System.out.println("=== Spring Core Demo ===\n");

        // Ex 1: Basic Spring Application
        System.out.println("--- Ex 1: Spring IoC Container ---");
        System.out.println("Spring Container started successfully!");
        System.out.println("Beans managed by Spring: " +
            context.getBeanDefinitionCount());

        // Ex 2: Dependency Injection
        System.out.println("\n--- Ex 2: Dependency Injection ---");
        UserService userService = context.getBean(UserService.class);

        String user = userService.getUser(1);
        System.out.println("Found user: " + user);

        userService.createUser("Karan");

        // Ex 4: Maven Project
        System.out.println("\n--- Ex 4: Maven Project ---");
        System.out.println("Maven project configured successfully!");
        System.out.println("Spring version: " +
            org.springframework.core.SpringVersion.getVersion());

        System.out.println("\n=== All exercises complete! ===");

        ((AnnotationConfigApplicationContext) context).close();
    }
}
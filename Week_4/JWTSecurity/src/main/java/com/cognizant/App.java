package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println("JWT Security Service running on port 8082!");
        System.out.println("POST http://localhost:8082/api/auth/login");
    }
}

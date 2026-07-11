package com.cognizant.loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoanServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(LoanServiceApp.class, args);
        System.out.println("Loan Service started on port 8084");
    }
}
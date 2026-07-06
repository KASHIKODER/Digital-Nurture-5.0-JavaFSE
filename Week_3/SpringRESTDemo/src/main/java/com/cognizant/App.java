package com.cognizant;

import com.cognizant.entity.Country;
import com.cognizant.repository.CountryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    CommandLineRunner initData(CountryRepository repo) {
        return args -> {
            repo.save(new Country("IN", "India", "New Delhi", "INR"));
            repo.save(new Country("US", "United States", "Washington DC", "USD"));
            repo.save(new Country("UK", "United Kingdom", "London", "GBP"));
            repo.save(new Country("JP", "Japan", "Tokyo", "JPY"));
            System.out.println("Sample data loaded!");
        };
    }
}

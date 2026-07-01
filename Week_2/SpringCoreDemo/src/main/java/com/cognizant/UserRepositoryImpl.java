package com.cognizant;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    public String findUserById(int id) {
        System.out.println("Fetching user from DB with id: " + id);
        return "Suyash Giri";
    }

    @Override
    public void saveUser(String name) {
        System.out.println("Saving user to DB: " + name);
    }
}
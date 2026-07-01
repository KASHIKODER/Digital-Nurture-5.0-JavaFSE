package com.cognizant;

public interface UserRepository {
    String findUserById(int id);
    void saveUser(String name);
}
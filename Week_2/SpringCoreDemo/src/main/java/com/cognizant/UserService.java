package com.cognizant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // Constructor Injection — DIP principle
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUser(int id) {
        return userRepository.findUserById(id);
    }

    public void createUser(String name) {
        userRepository.saveUser(name);
    }
}
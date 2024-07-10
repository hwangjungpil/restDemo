package com.example.restDemo.service;

import com.example.restDemo.model.User;
import com.example.restDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    // id is maked by new instance
    public User createUser(User user) {
        User newUser = new User(user.getName(), user.getEmail());
        return userRepository.save(newUser);
    }

    public User updateUser(Long id, User user) {
        User getUser = userRepository.findById(id).get();
        getUser.setName(user.getName());
        getUser.setEmail(user.getEmail());
        return userRepository.save(getUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}


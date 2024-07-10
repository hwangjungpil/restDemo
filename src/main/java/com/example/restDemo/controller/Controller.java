package com.example.restDemo.controller;

import com.example.restDemo.model.User;
import com.example.restDemo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devtest")
public class Controller {

    @Autowired
    private userService devTestService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return devTestService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return devTestService.getUserById(id);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return devTestService.createUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return devTestService.updateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        devTestService.deleteUser(id);
    }
}
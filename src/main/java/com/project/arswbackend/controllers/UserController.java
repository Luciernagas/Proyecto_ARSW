package com.project.arswbackend.controllers;

import com.project.arswbackend.entities.User;
import com.project.arswbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User newUser){
        return userService.create(newUser);
    }

    @GetMapping("/{username}")
    public User getByUsername(@PathVariable String username){
        return userService.findByUsername(username);
    }

}

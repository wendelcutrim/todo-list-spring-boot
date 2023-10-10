package br.com.wendelcutrim.todolist.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wendelcutrim.todolist.model.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping("/")
    public User create(@RequestBody User user) {
        //TODO: process POST request
        System.out.println(user.toString());
        return user;
    }

    
}

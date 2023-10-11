package br.com.wendelcutrim.todolist.controllers;

import br.com.wendelcutrim.todolist.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wendelcutrim.todolist.model.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody User userModel) {
        var user = this.userRepository.findByUsername(userModel.getUsername());
        String messageUserExists = "O usuário " + userModel.getUsername() + " já está sendo utilizado!";

        if(user != null) {
            System.out.println("Usuário já existe");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageUserExists);
        }

        var createdUser = this.userRepository.save(userModel);
        System.out.println(userModel.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    
}

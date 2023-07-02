package com.springtestes.Teste.controller;

import com.springtestes.Teste.entities.User;
import com.springtestes.Teste.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Usado para requisições HTTP <API>
@RestController
@RequestMapping(value = "/users")
public class UserController {

    //Injeta automaticamente o UserRepository (dependência), que tem acesso ao banco de dados por meio do JPA.
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> result = service.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User result = service.findById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/exist/{id}")
    public ResponseEntity<?> existInData(@PathVariable Long id){
        if(service.existsById(id)){
            return ResponseEntity.ok(service.findById(id));
        } else {
            String errorMessage ="USER NOT FOUND";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
}

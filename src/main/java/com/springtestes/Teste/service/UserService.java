package com.springtestes.Teste.service;

import com.springtestes.Teste.entities.User;
import com.springtestes.Teste.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Pode ser usado em lugares da aplicação
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long ID){
        Optional<User> obj = repository.findById(ID);
        return  obj.get();
    }

    public Boolean existsById(Long Id){
        return repository.existsById(Id);
    }
}

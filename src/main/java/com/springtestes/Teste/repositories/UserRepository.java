package com.springtestes.Teste.repositories;

import com.springtestes.Teste.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

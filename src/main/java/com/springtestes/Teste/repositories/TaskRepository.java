package com.springtestes.Teste.repositories;

import com.springtestes.Teste.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

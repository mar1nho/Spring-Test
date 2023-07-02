package com.springtestes.Teste.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "tb_tasks")
public class Task implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Item required")
    private String name;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;

    public Task(){}
    public Task(Long id, String name, Date date){
            this.id = id;
            this.name = name;
            this.date = date;
    }

}

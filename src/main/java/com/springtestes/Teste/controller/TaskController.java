package com.springtestes.Teste.controller;

import com.springtestes.Teste.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.springtestes.Teste.entities.Task;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

@Controller
public class TaskController {

    @Autowired
    TaskRepository repository;

    @GetMapping("/create")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("create");
        mv.addObject("task", new Task());
        return mv;
    }

    @PostMapping("/create")
    public String create(Task task) {
        repository.save(task);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public ModelAndView list() {
       ModelAndView mv = new ModelAndView("list");
       mv.addObject("tasks", repository.findAll());
       return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("create");
        Optional<Task> taskFind = repository.findById(id);
        mv.addObject("task", taskFind);
        return mv;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return "redirect:/list";
    }
}

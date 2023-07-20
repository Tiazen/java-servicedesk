package com.tiazen.servicedesk.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiazen.servicedesk.exceptions.TaskNotFoundException;
import com.tiazen.servicedesk.models.Task;
import com.tiazen.servicedesk.repositories.TaskRepository;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskRepository repository;

    TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    List<Task> all() {
        return repository.findAll();
    }

    @PostMapping("/create")
    Task createTask(@RequestBody Task newTask) {
        return repository.save(newTask);
    }

    @GetMapping("/{id}")
    Task returnTask(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
    }

    @PutMapping("/task/{id}")
    Task replaceTask(@RequestBody Task newTask, @PathVariable Long id) {

        return repository.findById(id)
        .map(task -> {
            task.setName(newTask.getName());
            task.setDescription(newTask.getDescription());
            return repository.save(task);
        }).orElseGet(() -> {
            newTask.setId(id);
            return repository.save(newTask);
          });
    }
}

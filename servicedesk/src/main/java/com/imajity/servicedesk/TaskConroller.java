package com.imajity.servicedesk;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskConroller {
    private final TaskRepository repository;

    TaskConroller(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/tasks")
    List<Task> all() {
        return repository.findAll();
    }

    @PostMapping("/task/create")
    Task createTask(@RequestBody Task newTask) {
        return repository.save(newTask);
    }

    @GetMapping("/task/{id}")
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

package com.tiazen.servicedesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiazen.servicedesk.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    
}

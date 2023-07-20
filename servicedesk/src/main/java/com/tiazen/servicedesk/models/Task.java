package com.tiazen.servicedesk.models;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Task {

    private @Id @GeneratedValue Long id;
    private String name;
    private String description;

    public Task() {}

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
    
    public String getDescription() {
        return this.description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof Task)) {
            return false;
        }
         
        Task task = (Task) o;

        return Objects.equals(this.hashCode(), task.hashCode());

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.description);
    }

    @Override
    public String toString() {
        return this.name + " " + this.description;
    }
}

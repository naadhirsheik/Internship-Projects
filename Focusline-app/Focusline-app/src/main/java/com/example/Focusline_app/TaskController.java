package com.example.Focusline_app;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;  

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;



public class TaskController {

    private final List<Task> tasks = new CopyOnWriteArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return tasks;
    }

    @GetMapping ("/tasks/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return findTaskById(id);
    }
    

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
        task.setId (idCounter.getAndIncrement());
        task.setCreatedAt(Instant.now());
        tasks.add(task);
        return task;
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        Task existingTask = findTaskById(id);

        return existingTask;
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id) {
        Task existingTask = findTaskById(id);
        tasks.remove(existingTask);
    }

    private Task findTaskById(Long id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));
    }



}
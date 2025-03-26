package com.example.demo.controller;

import com.example.demo.dto.InputTask;
import com.example.demo.dto.OutputResponseDto;
import com.example.demo.serviceImpl.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Get All Tasks
    @GetMapping
    public OutputResponseDto getAllTasks() {
        return taskService.getAllTasks();
    }

    // Get Task by ID
    @GetMapping("/{id}")
    public OutputResponseDto getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    // Create Task
    @PostMapping
    public OutputResponseDto createTask(@RequestBody InputTask inputTask) {
        return taskService.saveTask(inputTask);
    }

    // Update Task
    @PutMapping("/{id}")
    public OutputResponseDto updateTask(@PathVariable Long id, @RequestBody InputTask inputTask) {
        return taskService.updateTask(id, inputTask);
    }

    // Delete Task
    @DeleteMapping("/{id}")
    public OutputResponseDto deleteTask(@PathVariable Long id) {
        return taskService.deleteTask(id);
    }
}


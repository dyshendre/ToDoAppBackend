package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class InputTask implements Serializable {
    private String task;
    private String taskDescription;
    private Long employeeId;
    private LocalDateTime deadline;

    // No-argument constructor
    public InputTask() {
    }

    // Parameterized constructor
    public InputTask(String task, String taskDescription, Long employeeId, String department, LocalDateTime deadline) {
        this.task = task;
        this.taskDescription = taskDescription;
        this.employeeId = employeeId;
        this.deadline = deadline;
    }

    // Getters and Setters
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }
}


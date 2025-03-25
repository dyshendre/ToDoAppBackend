package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tasks")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    private String task;
    private String taskDescription;
    @ManyToOne  // Define Many-to-One relationship
    @JoinColumn(name = "id", nullable = false)
    private Employees employee;
    private String department;
    private LocalDateTime deadline;

    // No-argument constructor
    public Tasks() {
    }

    // Parameterized constructor
    public Tasks(Long taskId,String task, String taskDescription, Employees employee, String department, LocalDateTime deadline) {
        this.taskId=taskId;
        this.task = task;
        this.taskDescription = taskDescription;
        this.employee = employee;
        this.department = department;
        this.deadline = deadline;
    }

    // Getters and Setters
    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

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

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }
}

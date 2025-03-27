package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class InputTask {
    private String task;
    private String taskDescription;
    private Long employeeId;
    private LocalDateTime deadline;
}


package com.example.demo.serviceImpl;

import com.example.demo.dto.InputTask;
import com.example.demo.dto.OutputResponseDto;
import com.example.demo.model.Employees;
import com.example.demo.model.Tasks;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public OutputResponseDto getAllTasks() {
        List<Tasks> empList=taskRepository.findAll();
        return new OutputResponseDto(
            true,
            empList,
            "Task list retrived successfully.",
            "200");
    }

    public OutputResponseDto getTaskById(Long id) {
        Tasks emp=taskRepository.findById(id).orElse(null);
        return new OutputResponseDto(
            true,
            emp,
            "Task retrieved successfully.",
            "200");
    }

    @Transactional
    public OutputResponseDto saveTask(InputTask inputTask) {
        System.out.println("InputTask Employee Id==>"+inputTask.getEmployeeId());
        Tasks task = new Tasks(); 
        task.setTask(inputTask.getTask());
        task.setTaskDescription(inputTask.getTaskDescription());

        Optional<Employees> optEmp=employeeRepository.findById(inputTask.getEmployeeId());
        Employees emp=optEmp.orElse(null);
        if (optEmp.isPresent()) {
            task.setEmployee(emp);
            task.setDepartment(emp.getDepartment());
        }

        task.setDeadline(inputTask.getDeadline());
        taskRepository.save(task);
        return new OutputResponseDto(
            true,
            null,
            "Task saved successfully.",
            "200");
    }

    public OutputResponseDto updateTask(Long id, InputTask updatedTask) {
        Optional<Tasks> optionalExistingTask = taskRepository.findById(id); 
        if (optionalExistingTask.isPresent()) {
            Tasks existingTask = optionalExistingTask.orElse(null);
            
            existingTask.setTask(updatedTask.getTask());
            existingTask.setTaskDescription(updatedTask.getTaskDescription());

            Optional<Employees> optEmp=employeeRepository.findById(updatedTask.getEmployeeId());
            Employees emp=optEmp.orElse(null);
            if (optEmp.isPresent()) {
                existingTask.setEmployee(emp);
                existingTask.setDepartment(emp.getDepartment());
            }

            existingTask.setDeadline(updatedTask.getDeadline());
            taskRepository.save(existingTask);
            return new OutputResponseDto(
            true,
            null,
            "Task updated successfully.",
            "200");
        }
        return null;
    }

    public OutputResponseDto deleteTask(Long id) {
        taskRepository.deleteById(id);
        return new OutputResponseDto(
            true,
            null,
            "Task deleted successfully.",
            "200");
    }
}


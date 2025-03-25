package com.example.demo.controller;

import com.example.demo.dto.InputEmployee;
import com.example.demo.model.Employees;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Get All Employees
    @GetMapping
    public List<Employees> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get Employees by ID
    @GetMapping("/{id}")
    public Employees getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // Create Employees
    @PostMapping
    public Employees createEmployee(@RequestBody InputEmployee inputEmployee) {
        return employeeService.saveEmployee(inputEmployee);
    }

    // Update Employees
    @PutMapping("/{id}")
    public Employees updateEmployee(@PathVariable Long id, @RequestBody Employees employee) {
        return employeeService.updateEmployee(id, employee);
    }

    // Delete Employees
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}

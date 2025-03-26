package com.example.demo.serviceImpl;

import com.example.demo.dto.InputEmployee;
import com.example.demo.dto.OutputResponseDto;
import com.example.demo.model.Employees;
import com.example.demo.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employees> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employees getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Transactional
    public OutputResponseDto saveEmployee(InputEmployee inputEmployee) {
        Employees employee = new Employees(); // Convert DTO to entity
        employee.setName(inputEmployee.getName());
        employee.setUsername((inputEmployee.getUsername()));
        employee.setPhoneNumber(inputEmployee.getPhoneNumber());
        employee.setDepartment(inputEmployee.getDepartment());
        employee.setEmail(inputEmployee.getEmail());
        employee.setPassword((inputEmployee.getPassword()));
        employeeRepository.save(employee);
         return new OutputResponseDto(
            true,
            null,
            "Employee saved successfully.",
            "200");
    }

    public Employees updateEmployee(Long id, Employees updatedEmployee) {
        Optional<Employees> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()) {
            Employees employee = existingEmployee.get();
            employee.setName(updatedEmployee.getName());
            employee.setEmail(updatedEmployee.getEmail());
            employee.setDepartment(updatedEmployee.getDepartment());
            return employeeRepository.save(employee);
        }
        return null;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}

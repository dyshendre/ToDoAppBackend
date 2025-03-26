package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, Long> {
    Employees findByEmail(String email);
}

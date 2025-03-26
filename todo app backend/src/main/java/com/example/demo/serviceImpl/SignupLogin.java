package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.InputSignupDto;
import com.example.demo.dto.InputLoginDto;
import com.example.demo.dto.OutputResponseDto;
import com.example.demo.model.Employees;
import com.example.demo.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class SignupLogin {
 @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public OutputResponseDto signup(InputSignupDto inputSignupDto) {
        System.out.println("DTO Data: " + inputSignupDto);

        Employees emp=employeeRepository.findByEmail(inputSignupDto.getEmail());
        System.out.println("emp===>"+emp);
        if(emp!=null)
        {
            return new OutputResponseDto(
                false,
                null,
                "Employee with given email already exist.",
                "400");
        }
        Employees employee = new Employees(); // Convert DTO to entity
        employee.setName(inputSignupDto.getName());
        employee.setUsername((inputSignupDto.getUsername()));
        employee.setPhoneNumber(inputSignupDto.getPhoneNumber());
        employee.setDepartment(inputSignupDto.getDepartment());
        employee.setEmail(inputSignupDto.getEmail());
        employee.setPassword((inputSignupDto.getPassword()));
        Employees savedEmployee=employeeRepository.save(employee);
         return new OutputResponseDto(
            true,
            savedEmployee,
            "Signup successful saved successfully.",
            "200");
    }

    public OutputResponseDto login(InputLoginDto loginDto){
        Employees emp=employeeRepository.findByEmail(loginDto.getEmail());
        if(emp==null)
        {
            return new OutputResponseDto(
                false,
                null,
                "Employee with given email not found.",
                "400");
        }
        if(!emp.getPassword().equals(emp.getPassword()))
        {
            return new OutputResponseDto(
                false,
                null,
                "Password is incorrect.",
                "400");
        }
        return new OutputResponseDto(
            true,
            null,
            "Login successful.",
            "200");
    }
}

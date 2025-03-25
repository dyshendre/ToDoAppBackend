package com.example.demo.dto;

public class InputEmployee {
    private String name;
    private String email;
    private String department;

    public InputEmployee() {}

    public InputEmployee(String name, String email, String department) {
        this.name = name;
        this.email = email;
        this.department = department;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
}
}

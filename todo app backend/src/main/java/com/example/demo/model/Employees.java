package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="employees")
@Data
public class Employees {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String username;
    private String email;
    private String phoneNumber;
    private String department;
    private String password;

}



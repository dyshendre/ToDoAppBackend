package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputSignupDto {
private String name;
private String username;
private String email;
private String phoneNumber;
private String department;
private String password;
}

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Tasks;

public interface TaskRepository extends JpaRepository<Tasks, Long>{

}

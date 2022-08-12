package com.example.rdmssandbox.repository;


import com.example.rdmssandbox.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {

}
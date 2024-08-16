package com.example.EmployeeManagementSystem;

import com.example.EmployeeManagementSystem.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // JpaRepository provides basic CRUD methods as well as pagination and sorting methods.
}

package com.example.EmployeeManagementSystem;

import com.example.EmployeeManagementSystem.Employee;
import com.example.EmployeeManagementSystem.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e.name as name, e.email as email, d.name as departmentName " +
           "FROM Employee e JOIN e.department d")
    List<EmployeeProjection> findEmployeeDetails();
    
    @Query("SELECT new com.example.employeemanagementsystem.dto.EmployeeDTO(e.name, e.email, d.name) " +
    	       "FROM Employee e JOIN e.department d")
    List<EmployeeDTO> findEmployeeDTOs();

}

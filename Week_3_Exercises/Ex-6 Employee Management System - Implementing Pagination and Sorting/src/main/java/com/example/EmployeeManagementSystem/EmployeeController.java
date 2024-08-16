package com.example.EmployeeManagementSystem;

import com.example.EmployeeManagementSystem.Employee;
import com.example.EmployeeManagementSystem.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Endpoint for paginated employee list
    @GetMapping("/paged")
    public Page<Employee> getAllEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    // Endpoint for sorted employee list
    @GetMapping("/sorted")
    public List<Employee> getAllEmployeesSorted(@RequestParam String sortBy) {
        return employeeRepository.findAll(Sort.by(sortBy));
    }

    // Endpoint for paginated and sorted employee list
    @GetMapping("/paged-sorted")
    public Page<Employee> getAllEmployeesPagedAndSorted(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }
}

package com.example.employeeservice.service;

import com.example.employeeservice.domain.Employee;
import com.example.employeeservice.dto.request.EmployeeDtoRequest;
import com.example.employeeservice.dto.response.EmployeeDtoResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {

    ResponseEntity<Employee> createEmployee(EmployeeDtoRequest employeeDtoRequest);

    List<EmployeeDtoResponse> getEmployeeList();
    EmployeeDtoResponse getAllEmployeeAndSkillById (String id);
}

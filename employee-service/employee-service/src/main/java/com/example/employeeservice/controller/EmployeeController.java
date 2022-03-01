package com.example.employeeservice.controller;

import com.example.employeeservice.domain.Employee;
import com.example.employeeservice.dto.request.EmployeeDtoRequest;
import com.example.employeeservice.dto.response.EmployeeDtoResponse;
import com.example.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("employee")
public class EmployeeController {

    public final EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDtoRequest employeeDtoRequest){
        return new ResponseEntity(employeeService.createEmployee(employeeDtoRequest),HttpStatus.CREATED);
    }

    @GetMapping("/getEmployeeList")
    public ResponseEntity<List<EmployeeDtoResponse>> getAllEmployeeList(){
        return new ResponseEntity(employeeService.getEmployeeList(),HttpStatus.CREATED);
    }
}

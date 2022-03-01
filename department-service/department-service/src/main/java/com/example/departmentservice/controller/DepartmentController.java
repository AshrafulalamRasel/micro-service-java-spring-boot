package com.example.departmentservice.controller;

import com.example.departmentservice.domain.Department;
import com.example.departmentservice.dto.request.DepartmentDtoRequest;
import com.example.departmentservice.dto.response.DepartmentDtoResponse;
import com.example.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/create")
    public ResponseEntity<Department> createDepartment(@RequestBody DepartmentDtoRequest departmentDtoRequest){
        return new ResponseEntity(departmentService.createDepartment(departmentDtoRequest),HttpStatus.CREATED);
    }

    @GetMapping("/getAllList")
    public ResponseEntity<List<DepartmentDtoResponse>> getAllDepartmentList(){
        return new ResponseEntity(departmentService.getAllDepartmentList(),HttpStatus.OK);
    }

    @GetMapping("/getDepartmentBy/{id}")
    public ResponseEntity<DepartmentDtoResponse> getAllDepartmentBy(@PathVariable String id){
        return new ResponseEntity(departmentService.getAllDepartmentById(id),HttpStatus.OK);
    }
}

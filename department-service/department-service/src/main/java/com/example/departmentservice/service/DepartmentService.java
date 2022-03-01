package com.example.departmentservice.service;

import com.example.departmentservice.domain.Department;
import com.example.departmentservice.dto.request.DepartmentDtoRequest;
import com.example.departmentservice.dto.response.DepartmentDtoResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    ResponseEntity<Department> createDepartment(DepartmentDtoRequest departmentDtoRequest);

    List<DepartmentDtoResponse> getAllDepartmentList();

    DepartmentDtoResponse getAllDepartmentById(String id);
}

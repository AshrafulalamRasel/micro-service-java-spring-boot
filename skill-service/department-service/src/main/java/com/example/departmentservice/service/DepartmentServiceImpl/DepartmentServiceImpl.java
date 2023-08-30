package com.example.departmentservice.service.DepartmentServiceImpl;

import com.example.departmentservice.domain.Department;
import com.example.departmentservice.domain.repository.DepartmentRepository;
import com.example.departmentservice.dto.request.DepartmentDtoRequest;
import com.example.departmentservice.dto.response.DepartmentDtoResponse;
import com.example.departmentservice.service.DepartmentService;
import com.example.departmentservice.utils.UuidUtils;
import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final UuidUtils uuidUtils;


    @Override
    public ResponseEntity<Department> createDepartment(DepartmentDtoRequest departmentDtoRequest) {

        Department department = new Department();
        BeanUtils.copyProperties(departmentDtoRequest,department);
        department.setId(uuidUtils.getUuid());
        departmentRepository.saveAndFlush(department);

        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @Override
    public List<DepartmentDtoResponse> getAllDepartmentList() {

        List<DepartmentDtoResponse> departmentDtoResponseList = new ArrayList<>();

        List<Department> departmentList = departmentRepository.findAll();

        departmentList.forEach(departmentListDta->{

            DepartmentDtoResponse departmentDtoResponse = new DepartmentDtoResponse();
            departmentDtoResponse.setId(departmentListDta.getId());
            departmentDtoResponse.setDepartmentName(departmentListDta.getDepartmentName());
            departmentDtoResponse.setDepartmentCode(departmentListDta.getDepartmentCode());

            departmentDtoResponseList.add(departmentDtoResponse);

        });

        return departmentDtoResponseList;
    }

    @Override
    public DepartmentDtoResponse getAllDepartmentById(String id) {

        Optional<Department> departmentOptional = departmentRepository.findById(id);

        if (!departmentOptional.isPresent()){
            throw new RuntimeException("Not Found");
        }

        Department department = departmentOptional.get();

        return DepartmentDtoResponse.builder()
                .id(department.getId())
                .departmentName(department.getDepartmentName())
                .departmentCode(department.getDepartmentCode())
                .build();
    }
}

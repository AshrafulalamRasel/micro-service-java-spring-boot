package com.example.employeeservice.service.serviceImpl;

import com.example.employeeservice.apiClient.DepartmentClientService;
import com.example.employeeservice.apiClient.clientdto.DepartmentDtoResponse;
import com.example.employeeservice.domain.Employee;
import com.example.employeeservice.domain.repository.EmployeeRepository;
import com.example.employeeservice.dto.request.EmployeeDtoRequest;
import com.example.employeeservice.dto.response.EmployeeDtoResponse;
import com.example.employeeservice.service.EmployeeService;
import com.example.employeeservice.utils.UuidUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    public final UuidUtils uuidUtils;
    public final DepartmentClientService departmentClientService;

    @Override
    public ResponseEntity<Employee> createEmployee(EmployeeDtoRequest employeeDtoRequest) {


        Optional<DepartmentDtoResponse> departmentDtoResponse =
                departmentClientService.getAllDepartmentById(employeeDtoRequest.getDepartmentId());

        if (!departmentDtoResponse.isPresent()){
            throw new RuntimeException("Not Found Department");
        }


        DepartmentDtoResponse dtoResponse = departmentDtoResponse.get();


        Employee employee = new Employee();

        employee.setId(uuidUtils.getUuid());
        employee.setEmployeeName(employeeDtoRequest.getEmployeeName());
        employee.setEmployeeAge(employeeDtoRequest.getEmployeeAge());
        employee.setDepartmentId(dtoResponse.getId());
        employeeRepository.saveAndFlush(employee);

        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<EmployeeDtoResponse>> getEmployeeList() {

        List<EmployeeDtoResponse> employeeDtoResponseList = new ArrayList<>();

        List<Employee> employeeList = employeeRepository.findAll();

        employeeList.forEach(employeeListData->{

            Optional<DepartmentDtoResponse> departmentDtoResponse =
                    departmentClientService.getAllDepartmentById(employeeListData.getDepartmentId());


            EmployeeDtoResponse employeeDtoResponse = new EmployeeDtoResponse();
            employeeDtoResponse.setId(employeeListData.getId());
            employeeDtoResponse.setEmployeeName(employeeListData.getEmployeeName());
            employeeDtoResponse.setEmployeeAge(employeeListData.getEmployeeAge());
            employeeDtoResponse.setDepartmentList(departmentDtoResponse.get());
            employeeDtoResponseList.add(employeeDtoResponse);
        });




        return new ResponseEntity<>(employeeDtoResponseList,HttpStatus.OK);
    }
}

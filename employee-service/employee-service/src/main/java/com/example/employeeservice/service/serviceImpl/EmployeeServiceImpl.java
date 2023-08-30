package com.example.employeeservice.service.serviceImpl;

import com.example.employeeservice.apiClient.SkillClientService;
import com.example.employeeservice.apiClient.clientdto.SkillResponse;
import com.example.employeeservice.domain.Employee;
import com.example.employeeservice.domain.repository.EmployeeRepository;
import com.example.employeeservice.dto.request.EmployeeDtoRequest;
import com.example.employeeservice.dto.response.EmployeeDtoResponse;
import com.example.employeeservice.service.EmployeeService;
import com.example.employeeservice.utils.UuidUtils;
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
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    public final UuidUtils uuidUtils;
    public final SkillClientService skillClientService;

    @Override
    public ResponseEntity<Employee> createEmployee(EmployeeDtoRequest employeeDtoRequest) {


        Optional<SkillResponse> skillDtoResponse =
                skillClientService.getAllSkillById(employeeDtoRequest.getSkillId());

        if (!skillDtoResponse.isPresent()){
            throw new RuntimeException("Not Found Department");
        }


        SkillResponse dtoResponse = skillDtoResponse.get();


        Employee employee = new Employee();

        employee.setId(uuidUtils.getUuid());
        BeanUtils.copyProperties(employeeDtoRequest,employee);
        employee.setSkillId(dtoResponse.getId());
        employeeRepository.saveAndFlush(employee);

        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @Override
    public List<EmployeeDtoResponse> getEmployeeList() {

        List<EmployeeDtoResponse> employeeDtoResponseList = new ArrayList<>();

        List<Employee> employeeList = employeeRepository.findAll();

        employeeList.forEach(employeeListData->{

            Optional<SkillResponse> skillDtoResponse =
                    skillClientService.getAllSkillById(employeeListData.getSkillId());


            EmployeeDtoResponse employeeDtoResponse = new EmployeeDtoResponse();
            employeeDtoResponse.setId(employeeListData.getId());
            employeeDtoResponse.setEmployeeName(employeeListData.getEmployeeName());
            employeeDtoResponse.setEmployeeAge(employeeListData.getEmployeeAge());
            employeeDtoResponse.setDateOfBirth(employeeListData.getDateOfBirth());
            employeeDtoResponse.setAddress(employeeListData.getAddress());
            employeeDtoResponse.setSkillResponseList(skillDtoResponse.get());
            employeeDtoResponseList.add(employeeDtoResponse);
        });




        return employeeDtoResponseList;
    }



    @Override
    public EmployeeDtoResponse getAllEmployeeAndSkillById(String id) {

        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if (!employeeOptional.isPresent()) {
            throw new RuntimeException("Not Found");
        }

        Employee employee = employeeOptional.get();
        Optional<SkillResponse> skillDtoResponse =
                skillClientService.getAllSkillById(employee.getSkillId());


        return EmployeeDtoResponse.builder()
                .id(employee.getId())
                .employeeName(employee.getEmployeeName())
                .employeeAge(employee.getEmployeeAge())
                .address(employee.getAddress())
                .dateOfBirth(employee.getDateOfBirth())
                .skillName(skillDtoResponse.get().getSkillName())
                .build();
    }
}

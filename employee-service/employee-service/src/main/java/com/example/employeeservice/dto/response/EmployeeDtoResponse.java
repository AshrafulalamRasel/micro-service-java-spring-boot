package com.example.employeeservice.dto.response;

import com.example.employeeservice.apiClient.clientdto.DepartmentDtoResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDtoResponse {

    private String id;

    private String employeeName;

    private Integer employeeAge;

    private DepartmentDtoResponse departmentList;
}

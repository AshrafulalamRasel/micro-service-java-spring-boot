package com.example.employeeservice.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDtoRequest {

    private String employeeName;

    private Integer employeeAge;

    private String departmentId;
}

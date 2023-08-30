package com.example.employeeservice.dto.request;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@Builder
public class EmployeeDtoRequest {

    private String employeeName;

    private Integer employeeAge;

    private String skillId;

    private LocalDate dateOfBirth;

    private String address;
}

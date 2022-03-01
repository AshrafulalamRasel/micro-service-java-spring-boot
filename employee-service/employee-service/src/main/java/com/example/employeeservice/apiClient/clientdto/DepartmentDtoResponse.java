package com.example.employeeservice.apiClient.clientdto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDtoResponse {

    private String id;

    private String departmentName;

    private String departmentCode;
}

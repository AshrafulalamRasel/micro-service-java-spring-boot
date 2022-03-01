package com.example.departmentservice.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentDtoRequest {

    private String departmentName;

    private String departmentCode;
}

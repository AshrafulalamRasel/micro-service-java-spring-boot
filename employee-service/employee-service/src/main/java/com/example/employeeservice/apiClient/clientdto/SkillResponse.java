package com.example.employeeservice.apiClient.clientdto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SkillResponse {

    private String id;

    private String skillName;

    private String skillDescription;

    private Integer marks;
}

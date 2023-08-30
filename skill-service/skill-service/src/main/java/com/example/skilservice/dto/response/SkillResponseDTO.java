package com.example.skilservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SkillResponseDTO {

    private String id;

    private String skillName;

    private String skillDescription;

    private Integer marks;
}

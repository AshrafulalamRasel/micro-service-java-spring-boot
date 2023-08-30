package com.example.skilservice.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SkillRequestDTO {

    private String id;

    private String skillName;

    private String skillDescription;

    private Integer marks;
}

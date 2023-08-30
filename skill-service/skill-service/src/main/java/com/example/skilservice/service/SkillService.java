package com.example.skilservice.service;


import com.example.skilservice.domain.Skill;
import com.example.skilservice.dto.request.SkillRequestDTO;
import com.example.skilservice.dto.response.SkillResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SkillService {

    ResponseEntity<Skill> createSkill(SkillRequestDTO skillRequestDTO);

    List<SkillResponseDTO> getAllSkillList();

    SkillResponseDTO getAllSkillById(String id);
}

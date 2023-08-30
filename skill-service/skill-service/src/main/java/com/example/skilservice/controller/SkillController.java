package com.example.skilservice.controller;

import com.example.skilservice.domain.Skill;
import com.example.skilservice.dto.request.SkillRequestDTO;
import com.example.skilservice.dto.response.SkillResponseDTO;
import com.example.skilservice.service.SkillService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("/skill")
public class SkillController {

    private final SkillService skillService;

    @PostMapping("/create")
    public ResponseEntity<Skill> createSkill(@RequestBody SkillRequestDTO skillRequestDTO){
        return new ResponseEntity(skillService.createSkill(skillRequestDTO),HttpStatus.CREATED);
    }

    @GetMapping("/getAllList")
    public ResponseEntity<List<SkillResponseDTO>> getAllSkillList(){
        return new ResponseEntity(skillService.getAllSkillList(),HttpStatus.OK);
    }

    @GetMapping("/getSkillBy/{id}")
    public ResponseEntity<SkillResponseDTO> getAllSkillBy(@PathVariable String id){
        return new ResponseEntity(skillService.getAllSkillById(id),HttpStatus.OK);
    }
}

package com.example.skilservice.service.ServiceImpl;

import com.example.skilservice.domain.Skill;
import com.example.skilservice.domain.repository.SkillRepository;
import com.example.skilservice.dto.request.SkillRequestDTO;
import com.example.skilservice.dto.response.SkillResponseDTO;
import com.example.skilservice.service.SkillService;
import com.example.skilservice.utils.UuidUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;
    private final UuidUtils uuidUtils;


    @Override
    public ResponseEntity<Skill> createSkill(SkillRequestDTO skillRequestDTO) {

        if (skillRequestDTO.getId() != null){

            Optional<Skill> skillOptional = skillRepository.findById(skillRequestDTO.getId());
           if (!skillOptional.isPresent()){
               throw new RuntimeException("not found!!");
           }
            Skill skill = skillOptional.get();
            BeanUtils.copyProperties(skillRequestDTO, skill);
            skillRepository.save(skill);

            return new ResponseEntity<>(skill, HttpStatus.OK);
        }

        Skill skill = new Skill();
        BeanUtils.copyProperties(skillRequestDTO, skill);
        skill.setId(uuidUtils.getUuid());
        skillRepository.saveAndFlush(skill);

        return new ResponseEntity<>(skill, HttpStatus.CREATED);
    }

    @Override
    public List<SkillResponseDTO> getAllSkillList() {

        List<SkillResponseDTO> skillResponseList = new ArrayList<>();

        List<Skill> skillList = skillRepository.findAll();

        skillList.forEach(skill -> {

            SkillResponseDTO skillResponseDTO = new SkillResponseDTO();
            skillResponseDTO.setId(skill.getId());
            skillResponseDTO.setSkillName(skill.getSkillName());
            skillResponseDTO.setSkillDescription(skill.getSkillDescription());
            skillResponseDTO.setMarks(skill.getMarks());

            skillResponseList.add(skillResponseDTO);

        });

        return skillResponseList;
    }

    @Override
    public SkillResponseDTO getAllSkillById(String id) {

        Optional<Skill> skillOptional = skillRepository.findById(id);

        if (!skillOptional.isPresent()) {
            throw new RuntimeException("Not Found");
        }

        Skill skill = skillOptional.get();

        return SkillResponseDTO.builder()
                .id(skill.getId())
                .skillName(skill.getSkillName())
                .skillDescription(skill.getSkillDescription())
                .marks(skill.getMarks())
                .build();
    }
}

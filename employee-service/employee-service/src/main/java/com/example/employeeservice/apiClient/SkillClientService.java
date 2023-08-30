package com.example.employeeservice.apiClient;

import com.example.employeeservice.apiClient.clientdto.SkillResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;


//@FeignClient(name = "${localhost}", url = "${localhost:9001/department}")
@FeignClient(name = "SKILL-SERVICE", url = "localhost:3003/skill")
public interface SkillClientService {

    @RequestMapping(method = RequestMethod.GET, value = "/getAllList")
    List<SkillResponse> getAllDepartmentList();

    @RequestMapping(method = RequestMethod.GET, value = "/getSkillBy/{id}")
    Optional<SkillResponse> getAllSkillById(@PathVariable String id);
}

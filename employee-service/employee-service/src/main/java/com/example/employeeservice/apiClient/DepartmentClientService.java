package com.example.employeeservice.apiClient;

import com.example.employeeservice.apiClient.clientdto.DepartmentDtoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;


//@FeignClient(name = "${localhost}", url = "${localhost:9001/department}")
@FeignClient(name = "DEPARTMENT-SERVICE", url = "localhost:9001/department")
public interface DepartmentClientService {

    @RequestMapping(method = RequestMethod.GET, value = "/getAllList")
    List<DepartmentDtoResponse> getAllDepartmentList();

    @RequestMapping(method = RequestMethod.GET, value = "/getDepartmentBy/{id}")
    Optional<DepartmentDtoResponse> getAllDepartmentById(@PathVariable String id);
}

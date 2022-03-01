package com.example.departmentservice.domain;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Department extends BaseEntity{

    private String departmentName;

    private String departmentCode;

}

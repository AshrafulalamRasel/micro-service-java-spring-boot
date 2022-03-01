package com.example.employeeservice.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class Employee extends BaseEntity {

    private String employeeName;

    private Integer employeeAge;

    @Column(name ="department_id",nullable = false)
    private String departmentId;
}

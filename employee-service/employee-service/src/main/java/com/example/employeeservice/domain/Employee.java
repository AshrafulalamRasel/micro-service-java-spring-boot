package com.example.employeeservice.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@Entity
public class Employee extends BaseEntity {

    private String employeeName;

    private Integer employeeAge;

    @Column(name ="skillId",nullable = false)
    private String skillId;

    private LocalDate dateOfBirth;

    private String address;

}

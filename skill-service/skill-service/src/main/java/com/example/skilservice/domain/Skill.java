package com.example.skilservice.domain;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Skill extends BaseEntity{

    private String skillName;

    private String skillDescription;

    private Integer marks;

}

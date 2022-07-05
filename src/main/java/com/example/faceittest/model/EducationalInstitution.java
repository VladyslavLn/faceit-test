package com.example.faceittest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class EducationalInstitution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String state;
    private String name;
    @Column(name = "instituion_type")
    private String institutionType;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String website;
}

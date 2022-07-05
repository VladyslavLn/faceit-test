package com.example.faceittest.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "educational_institutions")
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

package com.example.faceittest.model.dto;

import lombok.Data;

@Data
public class EducationalInstitutionResponseDto {
    private Long id;
    private String state;
    private String name;
    private String institutionType;
    private String phoneNumber;
    private String website;
}

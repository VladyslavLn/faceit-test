package com.example.faceittest.mapper;

import com.example.faceittest.model.EducationalInstitution;
import com.example.faceittest.model.dto.EducationalInstitutionRequestDto;
import com.example.faceittest.model.dto.EducationalInstitutionResponseDto;
import org.springframework.stereotype.Component;

@Component
public class EducationalInstitutionMapper {
    public EducationalInstitutionResponseDto mapToDto(
            EducationalInstitution educationalInstitution) {
        EducationalInstitutionResponseDto responseDto = new EducationalInstitutionResponseDto();
        responseDto.setId(educationalInstitution.getId());
        responseDto.setName(educationalInstitution.getName());
        responseDto.setInstitutionType(educationalInstitution.getInstitutionType());
        responseDto.setState(educationalInstitution.getState());
        responseDto.setWebsite(educationalInstitution.getWebsite());
        responseDto.setPhoneNumber(educationalInstitution.getPhoneNumber());
        return responseDto;
    }

    public EducationalInstitution mapToModel(EducationalInstitutionRequestDto requestDto) {
        EducationalInstitution educationalInstitution = new EducationalInstitution();
        educationalInstitution.setName(requestDto.getName());
        educationalInstitution.setState(requestDto.getState());
        educationalInstitution.setWebsite(requestDto.getWebsite());
        educationalInstitution.setInstitutionType(requestDto.getInstitutionType());
        educationalInstitution.setPhoneNumber(requestDto.getPhoneNumber());
        return educationalInstitution;
    }
}

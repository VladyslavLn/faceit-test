package com.example.faceittest.service;

import com.example.faceittest.model.EducationalInstitution;
import java.util.List;
import org.springframework.data.domain.PageRequest;

public interface EducationalInstitutionService {
    void saveAll(List<EducationalInstitution> educationalInstitutions);

    List<EducationalInstitution> findAll(PageRequest pageRequest);
}

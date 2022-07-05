package com.example.faceittest.service.impl;

import com.example.faceittest.model.EducationalInstitution;
import com.example.faceittest.repository.EducationalInstitutionRepository;
import com.example.faceittest.service.EducationalInstitutionService;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class EducationalInstitutionServiceImpl implements EducationalInstitutionService {
    private final EducationalInstitutionRepository educationalInstitutionRepository;

    public EducationalInstitutionServiceImpl(
            EducationalInstitutionRepository educationalInstitutionRepository) {
        this.educationalInstitutionRepository = educationalInstitutionRepository;
    }

    @Override
    public void saveAll(List<EducationalInstitution> educationalInstitutions) {
        educationalInstitutionRepository.saveAll(educationalInstitutions);
    }

    @Override
    public List<EducationalInstitution> findAll(PageRequest pageRequest) {
        return educationalInstitutionRepository.findAll(pageRequest).toList();
    }
}

package com.example.faceittest.repository;

import com.example.faceittest.model.EducationalInstitution;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationalInstitutionRepository extends
        JpaRepositoryImplementation<EducationalInstitution, Long> {
    List<EducationalInstitution> findAllBy(Pageable pageable);
}

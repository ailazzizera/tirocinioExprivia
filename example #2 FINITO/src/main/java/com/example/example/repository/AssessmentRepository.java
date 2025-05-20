package com.example.example.repository;

import com.example.example.domain.documents.Assessment;
import java.util.List;
import java.util.Optional;

public interface AssessmentRepository {
    List<Assessment> findAll();
    Optional<Assessment> findById(String id);
    Assessment save(Assessment assessment);
    boolean deleteById(String id);
    Optional <Assessment> updateById(String id, Assessment updatedAssessment);  // Questo è il nuovo metodo aggiunto
}

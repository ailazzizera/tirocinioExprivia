package com.example.example.services;

import com.example.example.domain.documents.Assessment;

import java.util.List;
import java.util.Optional;

public interface AssessmentService {
    List<Assessment> listAssessments();
    Optional<Assessment> getAssessmentById(String id);
    Assessment createAssessment(Assessment assessment);
    Optional<Assessment> updateAssessment(String id, Assessment assessment);
    boolean deleteAssessment(String id);
}

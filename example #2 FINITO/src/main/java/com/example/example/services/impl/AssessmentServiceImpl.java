package com.example.example.services.impl;

import com.example.example.domain.documents.Assessment;
import com.example.example.repository.AssessmentRepository;
import com.example.example.services.AssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentRepository repository;

    @Override
    public List<Assessment> listAssessments() {
        return repository.findAll();
    }

    @Override
    public Optional<Assessment> getAssessmentById(String id) {
        return repository.findById(id);
    }

    @Override
    public Assessment createAssessment(Assessment assessment) {
        return repository.save(assessment);
    }

    @Override
    public Optional<Assessment> updateAssessment(String id, Assessment updatedAssessment) {
        return repository.updateById(id, updatedAssessment);
    }

    @Override
    public boolean deleteAssessment(String id) {
        return repository.deleteById(id);
    }
}

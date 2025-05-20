package com.example.example.mappers.impl;

import com.example.example.domain.documents.Assessment;
import com.example.example.domain.dtos.AssessmentDto;
import com.example.example.mappers.Mapper;
import org.springframework.stereotype.Component;

@Component
public class AssessmentMapper implements Mapper<Assessment, AssessmentDto> {

    @Override
    public AssessmentDto mapTo(Assessment assessment) {
        return new AssessmentDto(
                assessment.getAssessmentId(),
                assessment.getAssessmentName(),
                assessment.getSurveys(),
                assessment.getTools(),
                assessment.getEngine()
        );
    }

    @Override
    public Assessment mapFrom(AssessmentDto dto) {
        return new Assessment(
                dto.getAssessmentId(),
                dto.getAssessmentName(),
                dto.getSurveys(),
                dto.getTools(),
                dto.getEngine()
        );
    }
}

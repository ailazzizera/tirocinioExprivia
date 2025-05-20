package com.example.example.controllers;

import com.example.example.domain.documents.Assessment;
import com.example.example.domain.dtos.CreateUpdateAssessmentRequestDto;
import com.example.example.services.AssessmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/assessments")
public class AssessmentController {

    private final AssessmentService assessmentService;

    @GetMapping
    public List<Assessment> listAssessments() {
        return assessmentService.listAssessments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assessment> getAssessmentById(@PathVariable final String id) {
        return assessmentService.getAssessmentById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Assessment> createAssessment(@RequestBody final CreateUpdateAssessmentRequestDto requestDto) {
        Assessment assessment = requestDto.convertDtoToAssessment();
        assessment.setAssessmentId(null);
        Assessment created = assessmentService.createAssessment(assessment);
        return ResponseEntity.ok(created);
    }

    @PutMapping
    public ResponseEntity<Assessment> updateAssessment(
            @RequestBody final CreateUpdateAssessmentRequestDto requestDto
    ) {
        String id = requestDto.getAssessmentId();
        if (id == null || id.isBlank()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return assessmentService.updateAssessment(id, requestDto.convertDtoToAssessment())
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssessment(@PathVariable final String id) {
        if (assessmentService.deleteAssessment(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

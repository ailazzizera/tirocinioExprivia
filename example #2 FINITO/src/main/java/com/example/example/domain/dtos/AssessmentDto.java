package com.example.example.domain.dtos;

import com.example.example.domain.documents.Engine;
import com.example.example.domain.documents.Survey;
import com.example.example.domain.documents.Tool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentDto {
    private String assessmentId;
    private String assessmentName;
    private List<Survey> surveys;
    private List<Tool> tools;
    private Engine engine;
}

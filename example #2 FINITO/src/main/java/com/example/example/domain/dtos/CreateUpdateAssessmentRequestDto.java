package com.example.example.domain.dtos;

import com.example.example.domain.documents.Assessment;
import com.example.example.domain.documents.Engine;
import com.example.example.domain.documents.Survey;
import com.example.example.domain.documents.Tool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUpdateAssessmentRequestDto {
    private String assessmentId;
    private String assessmentName;
    private List<SurveyDto> surveys;
    private List<ToolDto> tools;
    private EngineDto engine;

    public Assessment convertDtoToAssessment() {
        List<Survey> survey = surveys != null
                ? surveys.stream().map(s -> new Survey(s.getName())).collect(Collectors.toList())
                : List.of();

        List<Tool> tool = tools != null
                ? tools.stream().map(t -> new Tool(t.getName())).collect(Collectors.toList())
                : List.of();

        Engine engineEntity = new Engine(engine != null ? engine.getName() : null);

        // Usa il costruttore completo
        return new Assessment(assessmentId, assessmentName, survey, tool, engineEntity);
    }


}

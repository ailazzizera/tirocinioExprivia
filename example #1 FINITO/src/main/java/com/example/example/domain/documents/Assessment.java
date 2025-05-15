package com.example.example.domain.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assessment {

    private String assessmentId;
    private List<Survey> surveys = new ArrayList<>();
    private List<Tool> tools = new ArrayList<>();
    private Engine engine;
}

package com.example.example.domain.documents;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assessment {

    @Id
    private String assessmentId;
    private String assessmentName;
    private List<Survey> surveys = new ArrayList<>();
    private List<Tool> tools = new ArrayList<>();
    private Engine engine;
}

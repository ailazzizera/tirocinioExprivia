package com.example.example;

import com.example.example.domain.documents.Assessment;
import com.example.example.domain.documents.Engine;
import com.example.example.domain.documents.Survey;
import com.example.example.domain.documents.Tool;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AppTest {

	@Test
	void baseCaseTest() {
		Survey surveyA = new Survey("survey_a");
		Survey surveyB = new Survey("survey_b");
		Tool toolA = new Tool("tool_a");
		Engine engine1 = new Engine("tec_engine");
		Engine engine2 = new Engine("compliance_engine");

		List<Survey> surveys = new ArrayList<>(List.of(surveyA, surveyB));
		List<Tool> tools = new ArrayList<>(List.of(toolA));
		List<Engine> engines = new ArrayList<>(List.of(engine1, engine2));

		List<Assessment> assessments = new ArrayList<>();

		// Assessment 1
		Assessment tec = new Assessment();
		tec.setAssessmentId("tec_assessment");
		tec.setSurveys(List.of(surveyA));
		tec.setTools(List.of(toolA));
		tec.setEngine(engine1);
		assessments.add(tec);

		// Assessment 2
		Assessment cis = new Assessment();
		cis.setAssessmentId("compliance_cis");
		cis.setSurveys(List.of(surveyA, surveyB));
		cis.setEngine(engine2);
		assessments.add(cis);

		// Assessment 3
		Assessment csirt = new Assessment();
		csirt.setAssessmentId("compliance_csirt");
		csirt.setSurveys(List.of(surveyB));
		csirt.setEngine(engine2);
		assessments.add(csirt);

	}
}

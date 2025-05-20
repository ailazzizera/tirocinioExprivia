package com.ai.GenAI.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/api/ai")
@AllArgsConstructor
public class AIController {

    private final RestClient restClient = RestClient.builder()
            .baseUrl("http://localhost:11434")
            .build();

    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping(value = "/prompt", produces = MediaType.APPLICATION_JSON_VALUE)
    public OllamaResponse inviaPrompt(@RequestBody PromptRequest request) throws JsonProcessingException {
        // Creo l’oggetto di richiesta
        OllamaRequest ollamaRequest = new OllamaRequest("tinyllama", request.getPrompt(), false);

        return restClient.post()
                .uri("/api/generate")
                .contentType(MediaType.APPLICATION_JSON)
                .body(ollamaRequest)
                .retrieve()
                .body(OllamaResponse.class);
    }

    @Data
    public static class PromptRequest {
        private String prompt;
    }

    @Data
    @AllArgsConstructor
    public static class OllamaRequest {
        private String model;
        private String prompt;
        private boolean stream;
    }

    @Data
    public static class OllamaResponse {
        private String response;
    }
}

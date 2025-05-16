package com.ai.GenAI.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/api/ai")
@AllArgsConstructor
public class AIController {

    private final RestClient restClient = RestClient.builder()
            .baseUrl("http://localhost:11434")
            .build();

    @PostMapping(value = "/prompt", produces = MediaType.APPLICATION_JSON_VALUE)
    public RispostaAI inviaPrompt(@RequestBody PromptRequest request) {
        String jsonRequest = String.format("""
            {
                "model": "tinyllama",
                "prompt": "%s",
                "stream": false
            }
            """, request.getPrompt());

        OllamaResponse response = restClient.post()
                .uri("/api/generate")
                .contentType(MediaType.APPLICATION_JSON)
                .body(jsonRequest)
                .retrieve()
                .body(OllamaResponse.class);

        return new RispostaAI(response != null ? response.getResponse().trim() : "Errore nella generazione della risposta.");
    }

    @Data
    public static class PromptRequest {
        private String prompt;
    }

    @Data
    public static class OllamaResponse {
        private String response;
    }

    @Data
    @AllArgsConstructor
    public static class RispostaAI {
        private String risposta;
    }
}

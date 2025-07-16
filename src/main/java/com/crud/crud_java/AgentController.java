package com.crud.crud_java;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class AgentController {

    // Substitua pelos seus dados
    private static final String AGENT_ID = "01JZ8S5T6NZRA7SAVC38FCKKAW";
    private static final String ACCESS_TOKEN = "APML7b2jxi7U1C9oy0WoD8W5sxuF1Cfyax9nUs770xMNw5vn3dzt4D2Cc1Tj2Kn8";


    @PostMapping("/invoke-agent")
    public ResponseEntity<String> invokeAgent(@RequestBody String prompt) {
        String url = "https://ai.stackspot.com/api/v1/agents/" + AGENT_ID + "/invoke";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(ACCESS_TOKEN);

        String requestBody = String.format("{\"prompt\": \"%s\"}", prompt);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}
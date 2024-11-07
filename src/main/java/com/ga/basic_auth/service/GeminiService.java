//package com.ga.basic_auth.service;
//
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponentsBuilder;
//
//@Service
//public class GeminiService {
//
//  @Value("${google.api.key}")
//  private String apiKey;
//
//  @Value("${google.api.url}")
//  private String apiUrl;
//
//  private final RestTemplate restTemplate = new RestTemplate();
//
//  public String generateResponse(String customPrompt) {
//    HttpHeaders headers = new HttpHeaders();
//    headers.setContentType(MediaType.APPLICATION_JSON);
//    headers.setBearerAuth(apiKey);
//
//    // Create JSON request body with custom prompt
//    JSONObject requestBody = new JSONObject();
//    requestBody.put("prompt", customPrompt);
//    requestBody.put("temperature", 0.7); // Customize parameters like temperature as needed
//
//    HttpEntity<String> entity = new HttpEntity<>(requestBody.toString(), headers);
//
//    // Send POST request to Gemini API
//    ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, entity, String.class);
//    return response.getBody();
//  }
//}

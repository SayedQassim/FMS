//package com.ga.basic_auth.controller;
//
//import com.ga.basic_auth.service.GeminiService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/ai")
//public class GeminiController {
//
//  @Autowired
//  private GeminiService geminiService;
//
//
//  @PostMapping("/generate")
//  public String generateText(@RequestBody String prompt) {
//    return geminiService.generateResponse(prompt);
//  }
//}

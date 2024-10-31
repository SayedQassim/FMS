package com.ga.basic_auth.controller;

import com.ga.basic_auth.model.Family;
import com.ga.basic_auth.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/family")
public class FamilyController {

  @Autowired
  private FamilyService familyService;

  @PostMapping
  public ResponseEntity<?> createFamily(@RequestBody Family family) {
    return familyService.createFamily(family);
  }
}

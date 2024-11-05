package com.ga.basic_auth.controller;

import com.ga.basic_auth.dto.request.GroceryItemDTO;
import com.ga.basic_auth.dto.request.GroceryListDTO;
import com.ga.basic_auth.service.GroceryListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/grocery")
public class GroceryListController {
  @Autowired
  private GroceryListService groceryListService;

  // Endpoint to create an empty grocery list for a family
  @PostMapping("/list")
  public ResponseEntity<?> createGroceryList(
           @RequestBody GroceryListDTO groceryListDTO) {
    return groceryListService.createGroceryList(groceryListDTO);
  }

  // Endpoint to add an item to an existing grocery list
  @PostMapping("/list/{groceryListId}/item")
  public ResponseEntity<?> addItemToList(
          @PathVariable Long groceryListId, @RequestBody GroceryItemDTO itemDTO) {
    return groceryListService.addItemToList(groceryListId, itemDTO);
  }
}

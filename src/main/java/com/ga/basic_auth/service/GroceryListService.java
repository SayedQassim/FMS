package com.ga.basic_auth.service;

import com.ga.basic_auth.dto.request.GroceryItemDTO;
import com.ga.basic_auth.dto.request.GroceryListDTO;
import com.ga.basic_auth.dto.response.ResponseTemplate;
import com.ga.basic_auth.model.GroceryItem;
import com.ga.basic_auth.model.GroceryList;
import com.ga.basic_auth.model.User;
import com.ga.basic_auth.repository.IGroceryItemRepository;
import com.ga.basic_auth.repository.IGroceryListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class GroceryListService implements BaseService {

  @Autowired
  private IGroceryListRepository groceryListRepository;

  @Autowired
  private IGroceryItemRepository groceryItemRepository;

  public ResponseEntity<?> createGroceryList(GroceryListDTO groceryListDTO) {

    User user = getCurrUser();

    GroceryList groceryList = new GroceryList();
    groceryList.setName(groceryListDTO.getName());
    groceryList.setFamily(user.getFamily());

    GroceryList savedList = groceryListRepository.save(groceryList);
    return new ResponseTemplate(HttpStatus.OK,"List Created" + savedList);
  }

  // Add item to an existing grocery list
  public ResponseEntity<?> addItemToList(Long groceryListId, GroceryItemDTO itemDTO) {
    Optional<GroceryList> groceryListOpt = groceryListRepository.findById(groceryListId);
    if (groceryListOpt.isEmpty()) {
      throw new RuntimeException("Grocery list not found");
    }

    GroceryList groceryList = groceryListOpt.get();
    GroceryItem item = new GroceryItem();
    item.setName(itemDTO.getName());
    item.setQuantity(itemDTO.getQuantity());
    item.setPrice(itemDTO.getPrice());
    item.setPurchased(itemDTO.isPurchased());
    item.setGroceryList(groceryList);

    GroceryItem savedItem = groceryItemRepository.save(item);
    return new ResponseTemplate(HttpStatus.OK,"Item Created" + savedItem);
  }


  private GroceryListDTO toGroceryListDTO(GroceryList groceryList) {
    GroceryListDTO dto = new GroceryListDTO();
    dto.setId(groceryList.getId());
    dto.setName(groceryList.getName());
    return dto;
  }

  private GroceryItemDTO toGroceryItemDTO(GroceryItem item) {
    GroceryItemDTO dto = new GroceryItemDTO();
    dto.setId(item.getId());
    dto.setName(item.getName());
    dto.setQuantity(item.getQuantity());
    dto.setPrice(item.getPrice());
    dto.setPurchased(item.isPurchased());
    return dto;
  }

}

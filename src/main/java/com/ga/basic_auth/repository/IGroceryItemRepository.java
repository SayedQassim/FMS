package com.ga.basic_auth.repository;

import com.ga.basic_auth.model.GroceryItem;
import com.ga.basic_auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGroceryItemRepository extends JpaRepository<GroceryItem, Long>, JpaSpecificationExecutor<GroceryItem> {
  List<GroceryItem> findByGroceryListId(Long groceryListId);
}

package com.ga.basic_auth.repository;

import com.ga.basic_auth.model.GroceryItem;
import com.ga.basic_auth.model.GroceryList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface IGroceryListRepository extends JpaRepository<GroceryList, Long>, JpaSpecificationExecutor<GroceryList> {
  public Optional<GroceryList> findByName(String name);
}

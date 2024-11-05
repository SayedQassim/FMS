package com.ga.basic_auth.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GroceryItemDTO {
  private Long id;
  private String name;
  private int quantity;
  private BigDecimal price;
  private boolean isPurchased;
}

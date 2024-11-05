package com.ga.basic_auth.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "grocery_item")
public class GroceryItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @Column
  private int quantity;

  @Column
  private BigDecimal price;

  @Column
  private boolean isPurchased;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "grocery_list_id", nullable = false)
  private GroceryList groceryList;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "family_id", nullable = false)
  private Family family;

}

package com.ga.basic_auth.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "grocery_list")
public class GroceryList {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "groceryList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<GroceryItem> items;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "family_id", nullable = false)
  private Family family;
}
